package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.dto.newBill;
import com.hotel.Hotel_manager.entity.Bill;
import com.hotel.Hotel_manager.mapper.BillMapper;
import com.hotel.Hotel_manager.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }
    public Bill getBillById(long id) {
        return billRepository.findById(id).orElse(null);

    }

    public List<Bill> getAllByTotalBetweenOrderByTotalDesc(double total, double total2){
        return billRepository.findAllByTotalBetweenOrderByTotalDesc(total, total2);
    }

    public List<Bill> findAllByDiscountBetweenOrderByDiscountDesc(double discount, double discount2){
        return billRepository.findAllByDiscountBetweenOrderByDiscountDesc(discount, discount2);
    }

    public List<Bill> findAllByDateBetweenOrderByDateDesc(Date start, Date end){
        return billRepository.findAllByDateBetweenOrderByDateDesc(start, end);
    }

    public List<Bill> findAllByCategory(String category){
        return billRepository.findAllByCategory(category);
    }

    public Bill findByEmail(String email){
        Optional<Bill> optional= billRepository.findByEmail(email);
        return optional.orElse(null);
    }

    public Bill createBill(newBill dto) {
        Bill bill = billMapper.dtoToBill(dto);
        return billRepository.save(bill);
    }
    public Bill updateBill(long id, newBill dto) {
        Optional<Bill> bill = billRepository.findById(id);
        if(bill.isPresent()) {
           bill.get().setTotal(dto.getTotal());
           bill.get().setDate(dto.getDate());
           bill.get().setSubtotal(dto.getSubtotal());
           bill.get().setDiscount(dto.getDiscount());
           bill.get().setEmail(dto.getEmail());
           bill.get().setCategory(dto.getCategory());
           bill.get().setInc(dto.getInc());
           bill.get().setIva(dto.getIva());
           return billRepository.save(bill.get());
        }
        return null;
    }

    public boolean deleteBill(long id) {
        if(billRepository.existsById(id)) {
            billRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
