package com.hotel.Hotel_manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BedRoomPK implements Serializable {

    @Column(name = "id_cama")
    private int bedId;

    @Column(name = "id_habitacion")
    private int roomId;
}
