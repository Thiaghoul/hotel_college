package com.unifacisa.hotel.repository;

import com.unifacisa.hotel.models.ReserveModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReserveRepository extends JpaRepository<ReserveModel, Integer> {
}
