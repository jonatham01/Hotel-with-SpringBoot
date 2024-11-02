package com.hotel.Hotel_manager.mapper;

import com.hotel.Hotel_manager.dto.NewBed;
import com.hotel.Hotel_manager.entity.Bed;

public class BedMapper {

    Bed dtoToBed(NewBed dto){
        return Bed.builder()
                .url(dto.getUrl())
                .date(dto.getDate())
                .bedCategoryId(dto.getBadCategoryId())
                .build();
    }
}
