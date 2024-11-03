package com.hotel.Hotel_manager.repository;

import com.hotel.Hotel_manager.entity.ReservationRoom;
import com.hotel.Hotel_manager.entity.ReservationRoomPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRoomRepository  extends JpaRepository<ReservationRoom, ReservationRoomPK> {
    List<ReservationRoom> findAllByQuantityBetween(int minQuantity, int maxQuantity);
}
