package com.example.FMXcarsrental.model.cdm;

public class ReservationRequest {
    private Long carId;
    private Long userId;

    // Getters and setters
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
