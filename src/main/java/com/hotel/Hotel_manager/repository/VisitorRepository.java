package com.hotel.Hotel_manager.repository;

import com.hotel.Hotel_manager.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor,Integer> {
}
