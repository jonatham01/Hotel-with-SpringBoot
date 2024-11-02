package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.dto.NewBed;
import com.hotel.Hotel_manager.entity.Bed;
import com.hotel.Hotel_manager.mapper.BedMapper;
import com.hotel.Hotel_manager.repository.BedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BedService {

    private final BedRepository bedRepository;
    private final BedMapper bedMapper;

    public List<Bed> getAllBeds() {
        return bedRepository.findAll();
    }

    public Bed getBedById(int id) {
        return bedRepository.findById(id).get();
    }

    public List<Bed> getAllBedsByDate(Date startDate, Date endDate) {
        return bedRepository.findByDateBetweenOrderByPriceAsc(startDate, endDate);
    }

    public List<Bed> getBedsByBedCategoryId(int bedCategoryId){
        return bedRepository.findByBedCategoryId(bedCategoryId);
    }

    public List<Bed> getBedsFiltered(Date startDate, Date endDate,int bedCategoryId){
        return bedRepository.findByDateBetweenOrderByPriceAsc(startDate, endDate)
                .stream().filter(data -> data.getBedCategoryId() == bedCategoryId).toList();
    }

    public Bed saveBed(NewBed dto) {
        Bed bed = bedMapper.dtoToBed(dto);
        return bedRepository.save(bed);
    }

    public boolean deleteBed(int id) {
        try {
            bedRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

