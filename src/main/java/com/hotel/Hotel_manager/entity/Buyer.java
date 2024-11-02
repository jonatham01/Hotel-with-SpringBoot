package com.hotel.Hotel_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cliente")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {

    @Id
    @Column(name = "cedula")
    private int documentNumber;

    @Column(name =  "nombre")
    private String name;

    @Column(name = "tipo_identificacion")
    private String identificationType;

    @OneToMany(mappedBy = "buyer")
    private List<Reservation> reservations;

}
