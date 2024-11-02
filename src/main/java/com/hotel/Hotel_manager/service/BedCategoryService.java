package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.dto.newBedCategory;
import com.hotel.Hotel_manager.entity.BedCategory;
import com.hotel.Hotel_manager.mapper.BedCategoryMapper;
import com.hotel.Hotel_manager.repository.BedCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class BedCategoryService  {


    private final BedCategoryRepository bedCategoryRepository;
    private final BedCategoryMapper bedCategoryMapper ;


    public List<BedCategory> getAll(){
        return bedCategoryRepository.findAll();
    }

    public Optional<BedCategory> getById(int id){
        return bedCategoryRepository.findById(id);
    }
    public List<BedCategory> getByColor(String color){
        return bedCategoryRepository.findAllByColor(color);
    }
    public List<BedCategory> getByKind(String kind){
        return bedCategoryRepository.findAllByKind(kind);
    }

    public BedCategory save(newBedCategory dto){
        BedCategory bedCategory = bedCategoryMapper.dtoToCategoryMapper(dto);
        return bedCategoryRepository.save(bedCategory);
    }

    public Optional<BedCategory> updateBedCategory(int id, newBedCategory dto){
        Optional<BedCategory> bedCategory = bedCategoryRepository.findById(id);
        if(bedCategory.isPresent()){
            bedCategory.get().setUrl(dto.getUrl());
            bedCategory.get().setColor(dto.getColor());
            bedCategory.get().setKind(dto.getKind());
            bedCategory.get().setMeasure(dto.getMeasure());
        }
        return bedCategory;
    }

    public boolean deleteBedCategory(int id){
        try{
            bedCategoryRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }


}
