package com.unifacisa.hotel.dto;

import com.unifacisa.hotel.models.HotelModel;
import com.unifacisa.hotel.models.ReserveModel;
import com.unifacisa.hotel.models.RoomType;

import java.util.Set;

public record RoomRecordDto(
        int capacity,
        RoomType roomType,
        Set<ReserveModel> reservations,
        Integer hotelId) { }
