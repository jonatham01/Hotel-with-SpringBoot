package com.hotel.Hotel_manager.repository;

import com.hotel.Hotel_manager.entity.ReservationVisitor;
import com.hotel.Hotel_manager.entity.ReservationVisitorPk;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationVisitorRepository extends JpaRepository<ReservationVisitor, ReservationVisitorPk> {

    List<ReservationVisitor> findByDateBetween(Date start, Date end);

    @Modifying
    @Transactional
    @Query("UPDATE reservacion_huesped e " +
            "SET e.date =:date, e.id_reservacion = :newReservationId, e.id_huesped = :newVisitorId " +
            "WHERE e.id_reservacion = :reservationId AND e.id_huesped =:visitorId")
    void updateFirstById(
            @Param("date") Date date,
            @Param("reservationId") Long reservationId,
            @Param("visitorId") int  visitorId,
            @Param("newReservationId") Long newReservationId ,
            @Param("newVisitorId") int newVisitorId);
}
