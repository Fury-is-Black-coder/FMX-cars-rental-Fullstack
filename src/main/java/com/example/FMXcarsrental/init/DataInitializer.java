package com.example.FMXcarsrental.init;

import com.example.FMXcarsrental.business.UserService;
import com.example.FMXcarsrental.dao.CarRepository;
import com.example.FMXcarsrental.dao.UserRepository;
import com.example.FMXcarsrental.model.entity.CarEntity;
import com.example.FMXcarsrental.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public DataInitializer(CarRepository carRepository, UserRepository userRepository, UserService userService) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        initDataDB();
    }

    private void initDataDB() {
        List <CarEntity> initCars = new ArrayList<>();
        initCars.add(new CarEntity("Toyota", "Camry", "ABC123"));
        initCars.add(new CarEntity("Honda", "Accord", "DEF456"));
        initCars.add(new CarEntity("Ford", "Mustang", "GHI789"));
        initCars.add(new CarEntity("Chevrolet", "Impala", "JKL101"));
        initCars.add(new CarEntity("Volkswagen", "Jetta", "MNO202"));
        initCars.add(new CarEntity("Nissan", "Altima", "PQR303"));
        initCars.add(new CarEntity("Hyundai", "Elantra", "STU404"));
        initCars.add(new CarEntity("Kia", "Optima", "VWX505"));
        initCars.add(new CarEntity("Mazda", "CX-5", "YZA606"));
        initCars.add(new CarEntity("Subaru", "Outback", "BCB707"));
        carRepository.saveAll(initCars);

        List<UserEntity> initUsers = new ArrayList<>();
        initUsers.add(new UserEntity(userService.generateLogin("Jan", "Kowalski"),"Jan", "Kowalski", "haslo1"));
        initUsers.add(new UserEntity(userService.generateLogin("Anna", "Nowak"),"Anna", "Nowak", "haslo2"));
        initUsers.add(new UserEntity(userService.generateLogin("Piotr", "Wiśniewski"),"Piotr", "Wiśniewski", "haslo3"));
        initUsers.add(new UserEntity(userService.generateLogin("Maria", "Dąbrowska"),"Maria", "Dąbrowska", "haslo4"));
        initUsers.add(new UserEntity(userService.generateLogin("Andrzej", "Lewandowski"),"Andrzej", "Lewandowski", "haslo5"));
        userRepository.saveAll(initUsers);
    }

}

