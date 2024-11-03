package com.hotel.Hotel_manager.repository;

import com.hotel.Hotel_manager.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByReservationDateBetween(Date start, Date end);
    List<Reservation> findAllByReservationDateAfter(Date end);
    List<Reservation> findAllByState(String state);
    List<Reservation> findAllByStateAndReservationDateBetween(String state, Date start, Date end);
    List<Reservation> findAllByStartDateBetween(Date start, Date end);
    List<Reservation> findAllByEndDate(Date end);
}
