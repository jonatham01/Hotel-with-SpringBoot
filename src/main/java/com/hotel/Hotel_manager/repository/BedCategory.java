package com.hotel.Hotel_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BedCategory extends JpaRepository<BedCategory, Integer> {

    List<BedCategory> findByBedCategoryId(int bedCategoryId);
    List<BedCategory> findByDateBetweenOrderByPriceAsc(Date startDate, Date endDate);
}
