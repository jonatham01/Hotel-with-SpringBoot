package com.hotel.Hotel_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "categoria_cama")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedCategory {

    @Id
    @Column(name = "id_categoria_cama")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo")
    private String kind;

    @Column(name = "medidas")
    private String measure;

    @Column(name = "foto_url")
    private String url;

    private String color;

    @OneToMany(mappedBy = "category")
    private List<Bed>  beds;

}
