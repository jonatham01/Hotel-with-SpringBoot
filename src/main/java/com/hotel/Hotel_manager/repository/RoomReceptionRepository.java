package com.hotel.Hotel_manager.repository;

import com.hotel.Hotel_manager.entity.RoomReception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RoomReceptionRepository extends JpaRepository<RoomReception, Integer> {
    List<RoomReception> findAllByDateBetweenOrderByDateAsc(Date startDate, Date endDate);
    List<RoomReception> findAllByCategoryOrderByDateAsc(String category);
}


