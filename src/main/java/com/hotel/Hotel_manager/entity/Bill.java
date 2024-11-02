package com.hotel.Hotel_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    @Id
    @Column(name = "id-factura")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    private double total;
    private double subtotal;
    private double iva;
    private double inc;

    @Column(name = "descuento")
    private double discount;

    @Column(name="categoria")
    private String category;

    @Column(name = "fecha-hora")
    private Date date;

    private String email;

    @OneToMany(mappedBy = "bill")
    private List<Reservation> reservationList;
}
