package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.entity.ReservationRoomPK;
import com.hotel.Hotel_manager.entity.ReservationVisitor;
import com.hotel.Hotel_manager.entity.ReservationVisitorPk;
import com.hotel.Hotel_manager.repository.ReservationRepository;
import com.hotel.Hotel_manager.repository.ReservationVisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationVisitorService {
    private final ReservationVisitorRepository repository;

    public ReservationVisitor save(long reservationId, int visitorId, Date reservationDate) {
        ReservationVisitorPk pk = new ReservationVisitorPk(reservationId, visitorId);
        boolean isPresent = repository.findById(pk).isPresent();
        if (isPresent) { return null;}
        ReservationVisitor reservationVisitor = new ReservationVisitor(pk, reservationDate);
        return repository.save(reservationVisitor);
    }

    public ReservationVisitor findById(long reservationVisitorId,int visitorId) {
        ReservationVisitorPk pk = new ReservationVisitorPk(reservationVisitorId, visitorId);
        return repository.findById(pk).orElse(null);
    }

    public List<ReservationVisitor> findAll(){
        return repository.findAll();
    }

    public List<ReservationVisitor> findByDate(Date date1,Date date2){
        return repository.findByDateBetween(date1,date2);
    }

    /*
    public ReservationVisitor update(long reservationVisitorId, int visitorId, Date reservationDate, long newReservationVisitorId, int newVisitorId) {
        repository.updateFirstById(reservationDate, newReservationVisitorId, newVisitorId,reservationVisitorId,visitorId);
        ReservationVisitorPk pk = new ReservationVisitorPk(newReservationVisitorId, newVisitorId);
        return repository.findById(pk).orElse(null);
    }

     */

    public boolean delete(long reservationVisitorId, int visitorId) {
        ReservationVisitorPk pk = new ReservationVisitorPk(reservationVisitorId, visitorId);
        ReservationVisitor reservationVisitor = repository.findById(pk).orElse(null);
        if (!repository.findById(pk).isPresent()) {
            return false;
        }
        repository.delete(reservationVisitor);
        return repository.findById(pk).isEmpty();
    }
}
