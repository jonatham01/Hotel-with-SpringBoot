package com.hotel.Hotel_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "huesped")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {

    @Id
    @Column(name = "cedula")
    private int identificationNumber;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "tipo_identificacion")
    private String identificationType;

    @Column(name="edad")
    private int age;

    @Column(name="genero")
    private String genre;
}
