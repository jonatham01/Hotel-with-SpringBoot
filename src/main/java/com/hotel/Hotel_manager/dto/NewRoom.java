package com.hotel.Hotel_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewRoom {
    private String name;
    private int floorNumber ;
    private int contactNumber;
    private int categoryId;
}
