package com.hotel.Hotel_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//clase Cama
@Entity
@Table(name = "cama")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bed {
    @Id
    @Column(name = "id_cama")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "recibo_url")
    private String url;

    @Column(name = "fecha_cama")
    private Date date;

    @Column(name = "id_categoriacama")
    private int bedCategoryId;

    @ManyToOne
    @JoinColumn(name = "bedCategoryId", insertable = false, updatable = false)
    private BedCategory category;


}
