package com.unifacisa.hotel.repository;

import com.unifacisa.hotel.models.GuestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GuestRepository extends JpaRepository<GuestModel, Integer> {

}
