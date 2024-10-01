package com.unifacisa.hotel.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_ROOM")
public class RoomModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private RoomType roomType;

    @OneToMany(mappedBy = "room")
    private Set<ReserveModel> reservations = new HashSet<ReserveModel>();

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelModel hotel;







}
