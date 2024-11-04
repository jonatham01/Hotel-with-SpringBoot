package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.dto.NewRoom;
import com.hotel.Hotel_manager.entity.Room;
import com.hotel.Hotel_manager.repository.RoomRepository;
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

public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService( ) {
        this.roomRepository = new RoomRepository() {
            @Override
            public List<Room> findAll(Sort sort) {
                return List.of();
            }

            @Override
            public Page<Room> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Room> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Room> List<S> saveAll(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public Optional<Room> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public List<Room> findAll() {
                return List.of();
            }

            @Override
            public List<Room> findAllById(Iterable<Integer> integers) {
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
            public void delete(Room entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> integers) {

            }

            @Override
            public void deleteAll(Iterable<? extends Room> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Room> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Room> List<S> saveAllAndFlush(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public void deleteAllInBatch(Iterable<Room> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Integer> integers) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Room getOne(Integer integer) {
                return null;
            }

            @Override
            public Room getById(Integer integer) {
                return null;
            }

            @Override
            public Room getReferenceById(Integer integer) {
                return null;
            }

            @Override
            public <S extends Room> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Room> List<S> findAll(Example<S> example) {
                return List.of();
            }

            @Override
            public <S extends Room> List<S> findAll(Example<S> example, Sort sort) {
                return List.of();
            }

            @Override
            public <S extends Room> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Room> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Room> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Room, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }

            @Override
            public List<Room> findAllByCategoryId(int categoryId) {
                return List.of();
            }

            @Override
            public List<Room> findAllByFloorNumber(int floorNumber) {
                return List.of();
            }
        };
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    public Room getRoomById(int id) {
        return roomRepository.findById(id).orElse(null);
    }
    public List<Room> getRoomByFloor(int floor) {
        return roomRepository.findAllByFloorNumber(floor);
    }

    public  List<Room> getRoomByCategoryId(int categoryId) {
        return roomRepository.findAllByCategoryId(categoryId);
    }

    public Room saveRoom(NewRoom newRoom) {
        Room room = new Room();
        room.setFloorNumber(newRoom.getFloorNumber());
        room.setCategoryId(newRoom.getCategoryId());
        room.setContactNumber(newRoom.getContactNumber());
        return roomRepository.save(room);
    }

    public Optional<Room> updateRoom(NewRoom newRoom, int id) {
       try {
           return roomRepository.findById(id)
                   .map(data -> {
                       data.setFloorNumber(newRoom.getFloorNumber());
                       data.setCategoryId(newRoom.getCategoryId());
                       data.setContactNumber(newRoom.getContactNumber());
                       return roomRepository.save(data);
                   });
       }catch (Exception e) {
           return Optional.empty();
       }
    }
    public boolean deleteRoom(int id) {
        try {
            roomRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
