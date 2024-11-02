package com.hotel.Hotel_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categoria-cama-habitacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedRoomCategory {

    @Id
    @EmbeddedId
    private BedRoomCategoryPK id;

    @Column(name = "cantidad")
    private short quantity;
}
