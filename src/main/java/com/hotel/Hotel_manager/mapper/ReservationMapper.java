package com.hotel.Hotel_manager.mapper;

import com.hotel.Hotel_manager.dto.NewResevation;
import com.hotel.Hotel_manager.entity.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    Reservation dtoToReservation(NewResevation newResevation){
        Reservation reservation = new Reservation();
        reservation.setReservationDate(newResevation.getReservationDate());
        reservation.setBillId(newResevation.getBillId());
        reservation.setClientId(newResevation.getClientId());
        reservation.setEndDate(newResevation.getEndDate());
        reservation.setStartDate(newResevation.getStartDate());
        reservation.setState(newResevation.getState());
        return reservation;
    }
}
