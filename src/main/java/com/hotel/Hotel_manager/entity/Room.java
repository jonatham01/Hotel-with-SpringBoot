package com.hotel.Hotel_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "habitacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @Column(name = "id_habitacion")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(name = "piso")
    private int floorNumber;

    @Column(name = "telefono")
    private int contactNumber;

    @Column(name = "id_categoria")
    private int categoryId;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private RoomCategory roomCategory;

    @OneToMany(mappedBy = "room")
    private List<RoomReception> receptionList;
}
