package com.hotel.Hotel_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "reserva")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @Column(name = "id_reserva")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "fecha_reserva")
    private Date reservationDate;

    @Column(name = "estado")
    private String state;

    @Column(name = "fecha_inicio")
    private LocalDate startDate;

    @Column(name= "fecha_fin")
    private LocalDate endDate;

    @Column(name = "id_cliente")
    private int clientId;

    @Column(name = "id_factura")
    private int billId;

    @ManyToOne
    @JoinColumn(name="clientId",nullable = false,updatable = false)
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name="billId",nullable = false,updatable = false)
    private Bill bill;


}
