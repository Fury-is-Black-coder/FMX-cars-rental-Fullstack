package com.example.FMXcarsrental.dao;

import com.example.FMXcarsrental.model.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, Long> {

    List<CarEntity> findByIsReservedFalse();
}
