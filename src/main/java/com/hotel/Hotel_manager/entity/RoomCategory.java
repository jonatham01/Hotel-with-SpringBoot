package com.hotel.Hotel_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categoria-habitacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomCategory {

    @Id
    @Column(name = "id_categoria_habitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "precio_noche")
    private double price;

    @Column(name= " foto_url")
    private String url;

    @OneToMany(mappedBy = "roomCategory")
    private List<Room> rooms;
}
