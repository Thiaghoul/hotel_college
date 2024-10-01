package com.unifacisa.hotel.controller;

import com.unifacisa.hotel.dto.HotelRecordDto;
import com.unifacisa.hotel.models.HotelModel;
import com.unifacisa.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<HotelModel> getAllHotels() {
        return hotelService.getAll();
    }

    @PostMapping
    public HotelModel saveHotel(@RequestBody HotelRecordDto hotel) {
        return hotelService.saveHotel(hotel);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Integer id) {
        hotelService.delete(id);
    }

    @PutMapping("/{id}")
    public HotelModel updateHotel(@PathVariable Integer id, @RequestBody HotelRecordDto hotel) {
        return hotelService.update(id, hotel);
    }

}
