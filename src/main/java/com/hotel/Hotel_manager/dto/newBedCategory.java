package com.hotel.Hotel_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class newBedCategory {

    private int id;
    private String kind;
    private String measure;
    private String url;
    private String color;

}
