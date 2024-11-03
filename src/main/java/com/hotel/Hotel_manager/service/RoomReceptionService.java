package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.dto.NewRoomReception;
import com.hotel.Hotel_manager.entity.RoomReception;
import com.hotel.Hotel_manager.mapper.RoomReceptionMapper;
import com.hotel.Hotel_manager.repository.RoomReceptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomReceptionService {
    private final RoomReceptionRepository roomReceptionRepository;
    private final RoomReceptionMapper roomReceptionMapper;

    public RoomReception save(NewRoomReception newRoomReception) {
        RoomReception roomReception = roomReceptionMapper.dtoToRoomReception(newRoomReception);
        return roomReceptionRepository.save(roomReception);
    }

    public List<RoomReception> findAll() {
        return roomReceptionRepository.findAll();
    }
    public RoomReception findById(int id) {
        return roomReceptionRepository.findById(id).orElse(null);
    }

    public List<RoomReception> findAllByDateBetweenOrderByDateAsc(Date startDate, Date endDate){
        return roomReceptionRepository.findAllByDateBetweenOrderByDateAsc(startDate, endDate);
    }

    public List<RoomReception> findAllByCategoryOrderByDateAsc(String category){
        return roomReceptionRepository.findAllByCategoryOrderByDateAsc(category);
    }

    public RoomReception update(RoomReception roomReception) {
        if( roomReceptionRepository.existsById(roomReception.getIdReception()) ){
            roomReceptionRepository.save(roomReception);
            return roomReception;
        }
        return null;
    }

    public boolean deleteById(int id) {
        roomReceptionRepository.deleteById(id);
        return !roomReceptionRepository.existsById(id);
    }
}
