package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.entity.BedRoom;
import com.hotel.Hotel_manager.entity.BedRoomPK;
import com.hotel.Hotel_manager.repository.BedRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BedRoomService {

    private final BedRoomRepository repository;

    public List<BedRoom> getAll() {
        return repository.findAll();
    }

    public Optional<BedRoom> findById(int bedId, int roomId) {
        BedRoomPK bedRoomPK = new BedRoomPK(bedId, roomId);
        return repository.findById(bedRoomPK);
    }

    public List<BedRoom> findByStatus(String status) {
        return repository.findAllByStatus(status);
    }

    public BedRoom save(int bedId, int roomId, String status) {
        BedRoomPK bedRoomPK = new BedRoomPK(bedId, roomId);
        BedRoom bedRoom = new BedRoom(bedRoomPK, status);
        return repository.save(bedRoom);
    }

    public BedRoom update(int bedId, int roomId, String status) {
        BedRoomPK bedRoomPK = new BedRoomPK(bedId, roomId);
        BedRoom bedRoom = new BedRoom(bedRoomPK, status);
        return repository.save(bedRoom);
    }

    public boolean delete(int bedId, int roomId) {
        try {
            BedRoomPK bedRoomPK = new BedRoomPK(bedId, roomId);
            repository.deleteById(bedRoomPK);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }


}
