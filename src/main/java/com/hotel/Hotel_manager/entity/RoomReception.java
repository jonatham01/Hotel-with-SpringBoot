package com.hotel.Hotel_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "recepcion-habitacion")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomReception {

    @Id
    @Column(name = "codigo_recepcion_habitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReception;

    @Column(name = "fecha")
    private Date date;

    @Column(name = "id_habitacion")
    private int roomId;

    @Column(name = "categoria")
    private String category;

    @ManyToOne
    @JoinColumn(name = "category", nullable = false,  updatable = false)
    private Room room;

}
