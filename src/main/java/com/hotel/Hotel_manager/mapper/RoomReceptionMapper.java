package com.hotel.Hotel_manager.mapper;

import com.hotel.Hotel_manager.dto.NewRoomReception;
import com.hotel.Hotel_manager.entity.RoomReception;

public class RoomReceptionMapper {

    RoomReception dtoToRoomReception(NewRoomReception dto) {
        RoomReception roomReception = new RoomReception();
        roomReception.setRoomId(dto.getRoomId());
        roomReception.setCategory(dto.getCategory());
        roomReception.setDate(dto.getDate());
        return roomReception;
    }
}
