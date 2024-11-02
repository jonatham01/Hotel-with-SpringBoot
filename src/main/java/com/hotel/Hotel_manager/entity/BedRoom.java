package com.hotel.Hotel_manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cama_habitacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedRoom {

    @EmbeddedId
    private BedRoomPK id;

    @Column(name = "estado")
    private String status;


}
