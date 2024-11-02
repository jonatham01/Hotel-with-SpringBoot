package com.hotel.Hotel_manager.repository;

import com.hotel.Hotel_manager.entity.BedRoomCategory;
import com.hotel.Hotel_manager.entity.BedRoomCategoryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BedRoomCategoryRepository extends JpaRepository<BedRoomCategory, BedRoomCategoryPK> {
    List<BedRoomCategory> findAllByQuantity(short quantity);
}
