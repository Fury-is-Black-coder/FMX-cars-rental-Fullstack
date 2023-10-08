package com.example.FMXcarsrental.controller;
import com.example.FMXcarsrental.dao.ReservationRepository;
import com.example.FMXcarsrental.dao.CarRepository;
import com.example.FMXcarsrental.dao.UserRepository;
import com.example.FMXcarsrental.model.cdm.ReservationRequest;
import com.example.FMXcarsrental.model.entity.CarEntity;
import com.example.FMXcarsrental.model.entity.ReservationEntity;
import com.example.FMXcarsrental.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controler {
    private final CarRepository carRepository;
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;


    @Autowired
    public Controler(CarRepository carRepository, ReservationRepository reservationRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/getAllCars")
    public List<CarEntity> getAllCars() {
        List<CarEntity> allCars = carRepository.findAll();
        return allCars;
    }

    @GetMapping("/getAvailableCars")
    public List<CarEntity> getAvailableCars() {
        List<CarEntity> availableCars = carRepository.findByIsReservedFalse();
        return availableCars;
    }

    @PostMapping("/addNewCar")
    public ResponseEntity<CarEntity> addNewCar(@RequestBody CarEntity newCar) {
        CarEntity savedCar = carRepository.save(newCar);
        System.out.println("Dodano nowy samochód: "+newCar);
        return ResponseEntity.ok(newCar);
    }

    // Rezerwuj pojazd
    @PostMapping("/reserveCar")
    public ResponseEntity<String> reserveCar(@RequestBody ReservationRequest reservationRequest) {
        CarEntity car = carRepository.findById(reservationRequest.getCarId()).orElse(null);
        if (car == null) {
            return ResponseEntity.badRequest().body("Samochód o podanym ID nie istnieje.");
        }

        if (car.isReserved()) {
            return ResponseEntity.badRequest().body("Samochód o podanym ID jest już zarezerwowany.");
        }

        UserEntity user = userRepository.findById(reservationRequest.getUserId()).orElse(null);
        if (user == null) {
            return ResponseEntity.badRequest().body("Użytkownik o podanym ID nie istnieje.");
        }

        ReservationEntity reservation = new ReservationEntity(new Date(), null,car,user);
        reservationRepository.save(reservation);

        car.setReserved(true);
        carRepository.save(car);

        return ResponseEntity.ok("Pomyślnie zarezerwowano samochód.");
    }

    // Zwolnij pojazd
    @PostMapping("/releaseCar")
    public ResponseEntity<String> releaseCar(@RequestParam Long reservationId) {
        Optional<ReservationEntity> reservationOptional = reservationRepository.findById(reservationId);
        if (!reservationOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Rezerwacja o podanym ID nie istnieje.");
        }

        ReservationEntity reservation = reservationOptional.get();

        CarEntity car = reservation.getCar();
        car.setReserved(false);
        carRepository.save(car);

        reservation.setEndTime(new Date());
        reservation.setFinished(true);

        reservationRepository.save(reservation);

        return ResponseEntity.ok("Pomyślnie zwolniono pojazd.");
    }

    @GetMapping("/getActiveReservation")
    public List<ReservationEntity> getActiveReservation() {
        List<ReservationEntity> activeReservations = reservationRepository.findByIsFinishedFalse();
        return activeReservations;
    }

    @GetMapping("/getAllReservation")
    public List<ReservationEntity> getAllReservation() {
        List<ReservationEntity> allReservations = reservationRepository.findAll();
        return allReservations;
    }

    @GetMapping("/reservationsByUser")
    public ResponseEntity<List<ReservationEntity>> getReservationsByUser(@RequestParam Long userId) {
        List<ReservationEntity> userReservations = reservationRepository.findByUserId(userId);

        if (userReservations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(userReservations);
    }

    @GetMapping("/activeReservationsByUser")
    public ResponseEntity<List<ReservationEntity>> activeReservationsByUser(@RequestParam Long userId) {
        List<ReservationEntity> activeUserReservations = reservationRepository.findActiveReservationsByUser(userId);

        if (activeUserReservations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(activeUserReservations);
    }

}
