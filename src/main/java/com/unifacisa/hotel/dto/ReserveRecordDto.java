package com.unifacisa.hotel.dto;

import com.unifacisa.hotel.models.GuestModel;
import com.unifacisa.hotel.models.RoomModel;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

public record ReserveRecordDto(
        LocalDate startDate,
        LocalDate endDate,
        Integer guestId,
        Integer roomId) { }
