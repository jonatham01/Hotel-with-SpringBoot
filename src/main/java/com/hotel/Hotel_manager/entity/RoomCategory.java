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

    @Column(name= " tv")
    private Boolean television;

    @Column(name= " aire_acondicionado")
    private Boolean air;

    @Column(name= "cobertura_nocturna")
    private Boolean nocturne;

    @Column(name= "veinticuatro_horas")
    private Boolean serviceAlways;

    @Column(name= "cafetera")
    private Boolean coffeeMaker;

    @Column(name= "minibar")
    private Boolean cooler;

    @Column(name= "caja_seguridad")
    private Boolean security;

    @Column(name= "leed_automatizada")
    private Boolean automatizationLed;

    @Column(name= "servicio_huesped")
    private Boolean visitorService;

    @Column(name= "despertador")
    private Boolean clock;

    @Column(name= "portatil")
    private Boolean laptop;

    @Column(name= "secador")
    private Boolean dryer;

    @Column(name= "telefono")
    private Boolean phone;

    @Column(name= "vista_almar")
    private Boolean seaView;

    @OneToMany(mappedBy = "roomCategory")
    private List<Room> rooms;


}
