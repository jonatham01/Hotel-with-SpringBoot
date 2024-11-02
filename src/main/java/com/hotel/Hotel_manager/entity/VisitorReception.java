package com.hotel.Hotel_manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "recepcion-huesped")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VisitorReception {

    @EmbeddedId
    private VisitorReceptionPK id;

    @Column(name = "fecha_recepcion")
    private Date date;
}
