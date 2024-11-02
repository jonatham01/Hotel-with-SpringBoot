package com.hotel.Hotel_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class newBill {
    private double total;
    private double subtotal;
    private double iva;
    private double inc;
    private double discount;
    private String category;
    private Date date;
    private String email;
}
