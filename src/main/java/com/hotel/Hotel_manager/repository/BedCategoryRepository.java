package com.hotel.Hotel_manager.repository;

import com.hotel.Hotel_manager.entity.BedCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BedCategoryRepository extends JpaRepository<BedCategory, Integer> {

    List<BedCategory> findAllByKind(String kind);
    List<BedCategory> findAllByColor(String color);
}
