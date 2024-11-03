package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.entity.Buyer;
import com.hotel.Hotel_manager.repository.BuyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuyerService {
    private final BuyerRepository buyerRepository;

    public List<Buyer> findAll() { return buyerRepository.findAll(); }

    Buyer findByIdentificationTypeAndAndDocumentNumber(String identificationType, int documentNumber){
        return buyerRepository.findByIdentificationTypeAndAndDocumentNumber(identificationType, documentNumber).orElse(null);
    }

    public Buyer save(Buyer buyer) { return buyerRepository.save(buyer); }

    public Buyer update(Buyer newBuyer, String type, int id) {
        Optional<Buyer> buyer = buyerRepository.findByIdentificationTypeAndAndDocumentNumber(type,id);
        if(newBuyer.getDocumentNumber() != id){
            buyerRepository.deleteById(id);
        }
        if (buyer.isPresent()) {
            buyer.get().setDocumentNumber(newBuyer.getDocumentNumber());
            buyer.get().setIdentificationType(newBuyer.getIdentificationType());
            buyer.get().setName(newBuyer.getName());
            return buyerRepository.save(buyer.get());
        }
        return null;
    }

    public boolean deleteById(int id) {
        if (buyerRepository.existsById(id)) {
            buyerRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
