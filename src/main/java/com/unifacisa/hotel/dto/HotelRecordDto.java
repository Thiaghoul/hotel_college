package com.unifacisa.hotel.dto;

import com.unifacisa.hotel.models.RoomModel;

import java.util.Set;

public record HotelRecordDto(
        String name,
        String address,
        Set<RoomModel> rooms) { }
