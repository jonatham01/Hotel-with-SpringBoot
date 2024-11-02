package com.hotel.Hotel_manager.repository;

import com.hotel.Hotel_manager.entity.BedRoom;
import com.hotel.Hotel_manager.entity.BedRoomPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BedRoomRepository extends JpaRepository<BedRoom, BedRoomPK> {

    List<BedRoom> findAllByStatus(String status);
}
