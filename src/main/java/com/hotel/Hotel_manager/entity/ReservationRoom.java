package com.hotel.Hotel_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "reserva-habitacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRoom {

    @EmbeddedId
    private ReservationRoomPK id;

    @Column(name = "cantidad")
    private short quantity;
}
