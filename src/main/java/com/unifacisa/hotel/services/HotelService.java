package com.unifacisa.hotel.services;

import com.unifacisa.hotel.dto.HotelRecordDto;
import com.unifacisa.hotel.models.HotelModel;
import com.unifacisa.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public HotelModel saveHotel(HotelRecordDto hotelRecordDto) {
        HotelModel hotelModel = new HotelModel();
        hotelModel.setName(hotelRecordDto.name());
        hotelModel.setAddress(hotelRecordDto.address());
        hotelModel.setRooms(hotelRecordDto.rooms());
        return hotelRepository.save(hotelModel);
    }

    public List<HotelModel> getAll() {
        return hotelRepository.findAll();
    }

    public void delete(Integer id) {

        hotelRepository.deleteById(id);
    }

    public HotelModel update(Integer id, HotelRecordDto hotelRecordDto) {
        HotelModel hotelModel = hotelRepository.findById(id).get();
        hotelModel.setName(hotelRecordDto.name());
        hotelModel.setAddress(hotelRecordDto.address());
        hotelModel.setRooms(hotelRecordDto.rooms());
        return hotelRepository.save(hotelModel);

    }
}
