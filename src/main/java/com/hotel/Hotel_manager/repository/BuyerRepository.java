package com.hotel.Hotel_manager.repository;

import com.hotel.Hotel_manager.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

    Optional<Buyer> findByIdentificationTypeAndAndDocumentNumber(String identificationType, int documentNumber);
}
