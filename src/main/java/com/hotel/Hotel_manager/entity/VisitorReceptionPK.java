package com.hotel.Hotel_manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VisitorReceptionPK  implements Serializable {

    @Column(name = "id_recepcion")
    private int reservationID;

    @Column(name = "id_huesped")
    private int visitorId;
}
