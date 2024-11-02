package com.hotel.Hotel_manager.mapper;

import com.hotel.Hotel_manager.dto.newBill;
import com.hotel.Hotel_manager.entity.Bill;
import org.springframework.stereotype.Component;

@Component
public class BillMapper {

    public Bill dtoToBill(newBill dto) {
        Bill bill = new Bill();
        bill.setCategory(dto.getCategory());
        bill.setDate(dto.getDate());
        bill.setInc(dto.getInc());
        bill.setDiscount(dto.getDiscount());
        bill.setEmail(dto.getEmail());
        bill.setSubtotal(dto.getSubtotal());
        bill.setTotal(dto.getTotal());
        return bill;
    }

}
