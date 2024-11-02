package com.hotel.Hotel_manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationVisitorPk implements Serializable {

    @Column(name = "id_reserva")
    private long reservationId;

    @Column(name = "id_huesped")
    private int visitorId;
}
