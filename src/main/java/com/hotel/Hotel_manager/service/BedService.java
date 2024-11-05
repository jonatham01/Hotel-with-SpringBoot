package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.dto.NewBed;
import com.hotel.Hotel_manager.entity.Bed;
import com.hotel.Hotel_manager.mapper.BedMapper;
import com.hotel.Hotel_manager.repository.BedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.sql.Date;
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

    public List<Bed> getBedsByBedCategoryId(int bedCategoryId){
        return bedRepository.findAllByBedCategoryId(bedCategoryId);
    }

    public List<Bed> getAllBedsByDate( Date startDate, Date endDate) {
        return bedRepository.findAll().stream()
                .filter(bed -> bed.getDate().after(startDate) && bed.getDate().before(endDate))
                .toList();
    }

    public List<Bed> getAllFiltered( Date startDate, Date endDate, int category) {
        return bedRepository.findAll().stream()
                .filter(bed -> bed.getDate().after(startDate) && bed.getDate().before(endDate))
                .filter(bed -> bed.getBedCategoryId() == category)
                .toList();
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

    public Bed updateBed(Bed bed,int id){
        if(bedRepository.findById(id).isPresent()) return bedRepository.save(bed);
        return null;
    }
}

