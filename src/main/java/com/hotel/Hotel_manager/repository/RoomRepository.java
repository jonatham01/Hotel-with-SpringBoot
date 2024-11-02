package com.hotel.Hotel_manager.repository;

import com.hotel.Hotel_manager.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByCategoryId(int categoryId);
    List<Room> findByFloorNumber(int floorNumber);
}
