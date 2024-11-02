package com.hotel.Hotel_manager.dto;

import com.hotel.Hotel_manager.entity.BedCategory;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewBed {
    private String url;
    private Date date;
    private int badCategoryId;

}
