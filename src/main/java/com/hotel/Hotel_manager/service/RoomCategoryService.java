package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.dto.NewRoomCategory;
import com.hotel.Hotel_manager.entity.RoomCategory;
import com.hotel.Hotel_manager.mapper.RoomCategoryMapper;
import com.hotel.Hotel_manager.repository.RoomCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomCategoryService {

     private final RoomCategoryRepository repository;
     private final RoomCategoryMapper mapper;


    public List<RoomCategory> getAll() {
         return repository.findAll();
     }

     public RoomCategory getById(int id) {
         return repository.findById(id).orElse(null);
     }

     public List<RoomCategory> getByPriceAsc(double price1,double price2) {
         return repository.findAllByPriceBetweenOrderByPriceAsc(price1,price2);
     }

    public List<RoomCategory> getByPriceDesc(double price1,double price2) {
        return repository.findAllByPriceBetweenOrderByPriceDesc(price1,price2);
    }

     public RoomCategory save(NewRoomCategory dto) {
        System.out.println("data del dto:"
                + "nombre" + dto.getName()
                +"  ,precio:" + dto.getPrice()
                +"  ,url" + dto.getUrl()
        );
         RoomCategory roomCategory= mapper.dtoToRoomCategory(dto);
         try {
             return repository.save(roomCategory);
         }
         catch (Exception e) {
             e.printStackTrace();
         }
         return null;
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
