package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.entity.ReservationRoom;
import com.hotel.Hotel_manager.entity.ReservationRoomPK;
import com.hotel.Hotel_manager.repository.ReservationRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationRoomService {
    private final ReservationRoomRepository reservationRoomRepository;

    public ReservationRoom save(long reservationId, int roomId, short quantity) {
        ReservationRoomPK pk = new ReservationRoomPK(reservationId, roomId);
        ReservationRoom reservationRoom = new ReservationRoom(pk,quantity);
        return reservationRoomRepository.save(reservationRoom);
    }

    public ReservationRoom findByReservationId(long reservationId, int roomId) {
        ReservationRoomPK pk = new ReservationRoomPK(reservationId, roomId);
        return reservationRoomRepository.findById(pk).orElse(null);
    }

    public List<ReservationRoom> findAll() {
        return reservationRoomRepository.findAll();
    }

    public List<ReservationRoom> findByQuantity(short quantity1, short quantity2) {
        return reservationRoomRepository.findAllByQuantityBetween(quantity1, quantity2);
    }

    public ReservationRoom update(long newReservationId, int newRoomId, short newQuantity,long reservationId, int roomId) {
        ReservationRoomPK pk = new ReservationRoomPK(reservationId, roomId);
        ReservationRoom reservationRoom = reservationRoomRepository.findById(pk).orElse(null);
        if( reservationId != newReservationId  || newRoomId != roomId){
            reservationRoomRepository.deleteById(pk);
        }
        if(reservationRoom != null){
            reservationRoom.setQuantity(newQuantity);
            return reservationRoomRepository.save(reservationRoom);
        }
        return null;
    }
    public boolean delete(long reservationId, int roomId) {
        ReservationRoomPK pk = new ReservationRoomPK(reservationId, roomId);
        reservationRoomRepository.findById(pk).ifPresent(reservationRoomRepository::delete);
        return reservationRoomRepository.existsById(pk);
    }

}
