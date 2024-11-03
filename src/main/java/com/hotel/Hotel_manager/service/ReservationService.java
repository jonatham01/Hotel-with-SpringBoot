package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.dto.NewResevation;
import com.hotel.Hotel_manager.entity.Reservation;
import com.hotel.Hotel_manager.mapper.ReservationMapper;
import com.hotel.Hotel_manager.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    public Reservation getReservationById(long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public List<Reservation> findAllByReservationDateBetween(Date start, Date end){
        return reservationRepository.findAllByReservationDateBetween(start, end);
    }

    public List<Reservation> findAllByReservationDateAfter(Date end){
        return reservationRepository.findAllByReservationDateAfter(end);
    }

    public List<Reservation> findAllByState(String state){
        return reservationRepository.findAllByState(state);
    }

    public List<Reservation> findAllByStateAndReservationDateBetween(String state, Date start, Date end){
        return reservationRepository.findAllByStateAndReservationDateBetween(state, start, end);
    }

    public List<Reservation> findAllByStartDateBetween(Date start, Date end){
        return reservationRepository.findAllByStartDateBetween(start, end);
    }

    public List<Reservation> findAllByEndDate(Date end){
        return reservationRepository.findAllByEndDate(end);
    }

    public Reservation save(NewResevation dto) {
        Reservation reservation = reservationMapper.dtoToReservation(dto);
        return reservationRepository.save(reservation);
    }

    public Reservation update(Reservation dto,long id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if(reservation != null){
            reservation.setReservationDate(dto.getReservationDate());
            reservation.setStartDate(dto.getStartDate());
            reservation.setEndDate(dto.getEndDate());
            reservation.setState(dto.getState());
            reservation.setClientId(dto.getClientId());
            reservation.setBillId(dto.getBillId());
            return reservationRepository.save(reservation);
        }
        return null;
    }

    public boolean delete(long id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if(reservation != null){
            reservationRepository.delete(reservation);
            return true;
        }
        return false;
    }



}
