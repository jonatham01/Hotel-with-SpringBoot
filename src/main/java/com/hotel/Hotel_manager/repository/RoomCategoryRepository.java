package com.hotel.Hotel_manager.repository;

import com.hotel.Hotel_manager.entity.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomCategoryRepository extends JpaRepository<RoomCategory, Integer> {

    List<RoomCategory> findByPriceBetweenOrderByPriceAsc(double price1, double price2);

    List<RoomCategory> findByPriceBetweenOrderByPriceDesc(double price1, double price2);

}
