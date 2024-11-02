package com.hotel.Hotel_manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BedRoomCategoryPK implements Serializable {

    @Column(name = "id_categoria_cama")
    private Integer idBedRoomCategory;

    @Column(name = "id_categoria_habitacion")
    private Integer idRoomCategory;

}
