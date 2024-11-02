package com.hotel.Hotel_manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "reserva-huesped")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationVisitor {

    @EmbeddedId
    private ReservationVisitorPk id;

    @Column(name = "fecha_reserva")
    private Date date;
}
