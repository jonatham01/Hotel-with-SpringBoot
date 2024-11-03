package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.entity.VisitorReception;
import com.hotel.Hotel_manager.entity.VisitorReceptionPK;
import com.hotel.Hotel_manager.repository.VisitorReceptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorReceptionService {
    private final VisitorReceptionRepository visitorReceptionRepository;

    public VisitorReception save(int reservationId, int visitorId, Date date) {
        VisitorReceptionPK pk = new VisitorReceptionPK(reservationId, visitorId);
        if (visitorReceptionRepository.existsById(pk)) {
            return null;
        }
        return visitorReceptionRepository.save(new VisitorReception(pk, date));
    }

    public List<VisitorReception> getAllVisitorReceptions() {
        return visitorReceptionRepository.findAll();
    }

    public VisitorReception getVisitorReceptionById(int reservationId, int visitorId) {
        VisitorReceptionPK pk = new VisitorReceptionPK(reservationId, visitorId);
        return visitorReceptionRepository.findById(pk).orElse(null);
    }

    public VisitorReception update(int reservationId, int visitorId,int newrReservationId, int newVisitorId, Date date) {
        VisitorReceptionPK pk = new VisitorReceptionPK(reservationId, visitorId);
        if (!visitorReceptionRepository.existsById(pk)) {
            return null;
        }
        if(reservationId != newrReservationId || visitorId != newVisitorId) {
            visitorReceptionRepository.deleteById(pk);
        }
        return visitorReceptionRepository.save(new VisitorReception(pk, date));
    }

    public boolean delete(int reservationId, int visitorId) {
        VisitorReceptionPK pk = new VisitorReceptionPK(reservationId, visitorId);
        if (!visitorReceptionRepository.existsById(pk)) {
            return false;
        }
        visitorReceptionRepository.deleteById(pk);
        return visitorReceptionRepository.existsById(pk);
    }
}
