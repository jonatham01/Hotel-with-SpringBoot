package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.dto.NewRoomCategory;
import com.hotel.Hotel_manager.entity.RoomCategory;
import com.hotel.Hotel_manager.mapper.RoomCategoryMapper;
import com.hotel.Hotel_manager.repository.RoomCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class RoomCategoryService {


     private final RoomCategoryRepository repository;
     private final RoomCategoryMapper mapper;


    public List<RoomCategory> getAll() {
         return repository.findAll();
     }

     public RoomCategory getById(int id) {
         return repository.findById(id).get();
     }

     public List<RoomCategory> getByPriceAsc(double price1,double price2) {
         return repository.findByPriceBetweenOrderByPriceAsc(price1,price2);
     }

    public List<RoomCategory> getByPriceDesc(double price1,double price2) {
        return repository.findByPriceBetweenOrderByPriceDesc(price1,price2);
    }

     public RoomCategory save(NewRoomCategory dto) {
         RoomCategory roomCategory= mapper.dtoToRoomCategory(dto);
         return repository.save(roomCategory);
     }

     public Optional<RoomCategory> update(NewRoomCategory dto, int id) {
        try {
            return repository.findById(id)
                    .map(data -> {
                        data.setName(dto.getName());
                        data.setPrice(dto.getPrice());
                        data.setUrl(dto.getUrl());
                        return repository.save(data);
                    });
        }catch (Exception e) {
            return Optional.empty();
        }

     }

     public boolean delete(int id) {
         try {
             repository.deleteById(id);
             return true;
         }
         catch (EmptyResultDataAccessException e) {
             return false;
         }
     }
}
