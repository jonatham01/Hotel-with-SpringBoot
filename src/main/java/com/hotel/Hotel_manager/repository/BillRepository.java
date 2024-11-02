package com.hotel.Hotel_manager.repository;

import com.hotel.Hotel_manager.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepository  extends JpaRepository<Bill, Long> {

    List<Bill> findAllByTotalBetweenOrderByTotalDesc(double total, double total2);
    List<Bill> findAllByDiscountBetweenOrderByDiscountDesc(double discount, double discount2);
    List<Bill> findAllByDateBetweenOrderByDateDesc(Date start, Date end);
    List<Bill> findAllByCategory(String category);
    Optional<Bill> findByEmail(String email);


}
