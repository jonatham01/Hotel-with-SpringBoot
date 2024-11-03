package com.hotel.Hotel_manager.repository;

import com.hotel.Hotel_manager.entity.VisitorReception;
import com.hotel.Hotel_manager.entity.VisitorReceptionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VisitorReceptionRepository extends JpaRepository<VisitorReception, VisitorReceptionPK> {

    List<VisitorReception> findAllByDateBetweenOrderByDateAsc(Date start, Date end);
}
