package com.example.FMXcarsrental.dao;

import com.example.FMXcarsrental.model.entity.CarEntity;
import com.example.FMXcarsrental.model.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findByIsFinishedFalse();

    List<ReservationEntity> findByUserId(Long userId);

    @Query("SELECT r FROM ReservationEntity r WHERE r.user.id = :userId AND r.isFinished = false")
    List<ReservationEntity> findActiveReservationsByUser(@Param("userId") Long userId);
}
