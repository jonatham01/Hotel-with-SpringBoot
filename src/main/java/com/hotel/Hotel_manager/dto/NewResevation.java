package com.hotel.Hotel_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewResevation {
    private Date reservationDate;
    private String state;
    private LocalDate startDate;
    private LocalDate endDate;
    private int clientId;
    private int billId;

}
