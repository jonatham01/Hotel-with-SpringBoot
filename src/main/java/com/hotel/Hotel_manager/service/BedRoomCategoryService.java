package com.hotel.Hotel_manager.service;

import com.hotel.Hotel_manager.entity.BedRoomCategory;
import com.hotel.Hotel_manager.entity.BedRoomCategoryPK;
import com.hotel.Hotel_manager.repository.BedRoomCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BedRoomCategoryService {

    private final BedRoomCategoryRepository repository;

    public List<BedRoomCategory> getAll() {
        return repository.findAll();
    }
    public Optional<BedRoomCategory> getById(int idBedRoomCategory, int idRoomCategory) {
        BedRoomCategoryPK pk = new BedRoomCategoryPK(idBedRoomCategory,idRoomCategory);
        return repository.findById(pk);
    }

    public List<BedRoomCategory> getByQuantity(short quantity) {
        return repository.findAllByQuantity(quantity);
    }

    public BedRoomCategory save(int idBedRoomCategory, int idRoomCategory,short quantity) {
        BedRoomCategoryPK pk = new BedRoomCategoryPK(idBedRoomCategory,idRoomCategory);
        return repository.save(new BedRoomCategory(pk,quantity));
    }

    public Optional<BedRoomCategory> update(int idBedRoomCategory, int idRoomCategory, short quantity) {
        BedRoomCategoryPK pk = new BedRoomCategoryPK(idBedRoomCategory,idRoomCategory);
        return repository.findById(pk).map(data -> {
            data.setQuantity(quantity);
            return repository.save(data);
        });
    }

    public boolean delete(int idBedRoomCategory, int idRoomCategory) {
        repository.deleteById(new BedRoomCategoryPK(idBedRoomCategory,idRoomCategory));
        return !repository.existsById(new BedRoomCategoryPK(idBedRoomCategory, idRoomCategory));
    }
}
