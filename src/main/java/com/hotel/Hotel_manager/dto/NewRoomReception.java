package com.hotel.Hotel_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewRoomReception {
    private Date date;
    private int roomId;
    private String category;
}
