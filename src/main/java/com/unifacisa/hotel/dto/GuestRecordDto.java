package com.unifacisa.hotel.dto;

import com.unifacisa.hotel.models.ReserveModel;

import java.time.LocalDate;
import java.util.Set;

public record GuestRecordDto(
        String name,
        LocalDate birthDate,
        Set<ReserveModel> reservations) { }
