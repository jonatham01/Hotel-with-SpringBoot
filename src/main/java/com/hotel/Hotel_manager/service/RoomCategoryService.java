package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.dto.NewRoomCategory;
import com.hotel.Hotel_manager.entity.RoomCategory;
import com.hotel.Hotel_manager.mapper.RoomCategoryMapper;
import com.hotel.Hotel_manager.repository.RoomCategoryRepository;
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
public class RoomCategoryService {


     RoomCategoryRepository repository;
     RoomCategoryMapper mapper;

    public RoomCategoryService() {
        this.repository = new RoomCategoryRepository() {
            @Override
            public List<RoomCategory> findAll(Sort sort) {
                return List.of();
            }

            @Override
            public Page<RoomCategory> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends RoomCategory> S save(S entity) {
                return null;
            }

            @Override
            public <S extends RoomCategory> List<S> saveAll(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public Optional<RoomCategory> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public List<RoomCategory> findAll() {
                return List.of();
            }

            @Override
            public List<RoomCategory> findAllById(Iterable<Integer> integers) {
                return List.of();
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(RoomCategory entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> integers) {

            }

            @Override
            public void deleteAll(Iterable<? extends RoomCategory> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends RoomCategory> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends RoomCategory> List<S> saveAllAndFlush(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public void deleteAllInBatch(Iterable<RoomCategory> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Integer> integers) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public RoomCategory getOne(Integer integer) {
                return null;
            }

            @Override
            public RoomCategory getById(Integer integer) {
                return null;
            }

            @Override
            public RoomCategory getReferenceById(Integer integer) {
                return null;
            }

            @Override
            public <S extends RoomCategory> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends RoomCategory> List<S> findAll(Example<S> example) {
                return List.of();
            }

            @Override
            public <S extends RoomCategory> List<S> findAll(Example<S> example, Sort sort) {
                return List.of();
            }

            @Override
            public <S extends RoomCategory> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends RoomCategory> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends RoomCategory> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends RoomCategory, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }

            @Override
            public List<RoomCategory> findByPriceBetweenOrderByPriceAsc(double price1, double price2) {
                return List.of();
            }

            @Override
            public List<RoomCategory> findByPriceBetweenOrderByPriceDesc(double price1, double price2) {
                return List.of();
            }
        };
        this.mapper = new RoomCategoryMapper();
    }

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
