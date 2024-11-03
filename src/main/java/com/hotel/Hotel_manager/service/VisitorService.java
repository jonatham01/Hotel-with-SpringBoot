package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.entity.Visitor;
import com.hotel.Hotel_manager.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorService {

    private final VisitorRepository visitorRepository;

    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    public Visitor getVisitorById(int id) {
        return visitorRepository.findById(id).orElse(null);
    }

    public Visitor saveVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    public Visitor updateVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    public boolean deleteVisitorById(int id) {
        visitorRepository.deleteById(id);
        return !visitorRepository.existsById(id);
    }

}
