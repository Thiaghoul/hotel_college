package com.unifacisa.hotel.repository;

import com.unifacisa.hotel.models.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<HotelModel, Integer> {

}
