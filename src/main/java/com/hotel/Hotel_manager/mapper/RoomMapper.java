package com.hotel.Hotel_manager.mapper;

import com.hotel.Hotel_manager.dto.NewRoom;
import com.hotel.Hotel_manager.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    Room dtoToRoom(NewRoom dto){
        Room room = new Room();
        room.setCategoryId(dto.getCategoryId());
        room.setContactNumber(dto.getContactNumber());
        room.setFloorNumber(dto.getFloorNumber());
        return room;
    }
}
