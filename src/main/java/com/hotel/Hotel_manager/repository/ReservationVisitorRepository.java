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


}
