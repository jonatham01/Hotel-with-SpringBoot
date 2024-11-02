package com.hotel.Hotel_manager.repository;

import com.hotel.Hotel_manager.entity.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BedRepository extends JpaRepository<Bed, Integer> {

    List<Bed> findByDateBetweenOrderByPriceAsc(Date startDate, Date endDate);

    List<Bed> findByBedCategoryId(int bedCategoryId);
}
