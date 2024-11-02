package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.dto.NewRoom;
import com.hotel.Hotel_manager.entity.Room;
import com.hotel.Hotel_manager.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class RoomService {

    private final RoomRepository roomRepository;



    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    public Room getRoomById(int id) {
        return roomRepository.findById(id).get();
    }
    public List<Room> getRoomByFloor(int floor) {
        return roomRepository.findAllByFloorNumber(floor);
    }

    public  List<Room> getRoomByCategoryId(int categoryId) {
        return roomRepository.findAllByCategoryId(categoryId);
    }

    public Room saveRoom(NewRoom newRoom) {
        Room room = new Room();
        room.setFloorNumber(newRoom.getFloorNumber());
        room.setCategoryId(newRoom.getCategoryId());
        room.setContactNumber(newRoom.getContactNumber());
        return roomRepository.save(room);
    }

    public Optional<Room> updateRoom(NewRoom newRoom, int id) {
       try {
           return roomRepository.findById(id)
                   .map(data -> {
                       data.setFloorNumber(newRoom.getFloorNumber());
                       data.setCategoryId(newRoom.getCategoryId());
                       data.setContactNumber(newRoom.getContactNumber());
                       return roomRepository.save(data);
                   });
       }catch (Exception e) {
           return Optional.empty();
       }
    }
    public boolean deleteRoom(int id) {
        try {
            roomRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
