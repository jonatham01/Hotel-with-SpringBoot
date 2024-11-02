package com.hotel.Hotel_manager.mapper;

import com.hotel.Hotel_manager.dto.NewRoomCategory;
import com.hotel.Hotel_manager.entity.RoomCategory;
import org.springframework.stereotype.Component;

@Component
public class RoomCategoryMapper {

    public RoomCategory dtoToRoomCategory(NewRoomCategory dto) {
        RoomCategory roomCategory = new RoomCategory();
        roomCategory.setName(dto.getName());
        roomCategory.setUrl(dto.getUrl());
        roomCategory.setPrice(dto.getPrice());
        return roomCategory;
    }
}
