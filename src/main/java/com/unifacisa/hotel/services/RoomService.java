package com.unifacisa.hotel.services;

import com.unifacisa.hotel.dto.RoomRecordDto;
import com.unifacisa.hotel.models.RoomModel;
import com.unifacisa.hotel.repository.HotelRepository;
import com.unifacisa.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    public RoomModel save(RoomRecordDto roomRecordDto){
        RoomModel roomModel = new RoomModel();
        roomModel.setCapacity(roomRecordDto.capacity());
        roomModel.setRoomType(roomRecordDto.roomType());
        roomModel.setReservations(roomRecordDto.reservations());
        roomModel.setHotel(hotelRepository.findById(roomRecordDto.hotelId()).get());
        return roomRepository.save(roomModel);
    }

    public List<RoomModel> getAll(){
        return roomRepository.findAll();
    }

    public void delete(Integer id){
        roomRepository.deleteById(id);
    }

    public RoomModel update(Integer id, RoomRecordDto roomRecordDto){
        RoomModel roomModel = roomRepository.findById(id).get();
        roomModel.setCapacity(roomRecordDto.capacity());
        roomModel.setRoomType(roomRecordDto.roomType());
        roomModel.setReservations(roomRecordDto.reservations());
        roomModel.setHotel(hotelRepository.findById(roomRecordDto.hotelId()).get());
        return roomRepository.save(roomModel);
    }


}
