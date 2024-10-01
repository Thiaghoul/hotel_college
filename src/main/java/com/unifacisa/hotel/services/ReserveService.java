package com.unifacisa.hotel.services;

import com.unifacisa.hotel.dto.ReserveRecordDto;
import com.unifacisa.hotel.models.HotelModel;
import com.unifacisa.hotel.models.ReserveModel;
import com.unifacisa.hotel.models.RoomModel;
import com.unifacisa.hotel.repository.GuestRepository;
import com.unifacisa.hotel.repository.HotelRepository;
import com.unifacisa.hotel.repository.ReserveRepository;
import com.unifacisa.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveService {

    private final ReserveRepository reserveRepository;
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    @Autowired
    public ReserveService(ReserveRepository reserveRepository, GuestRepository guestRepository,
                          RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.reserveRepository = reserveRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    public ReserveModel save(ReserveRecordDto reserveRecordDto){
        ReserveModel reserveModel = new ReserveModel();
        reserveModel.setStartDate(reserveRecordDto.startDate());
        reserveModel.setEndDate(reserveRecordDto.endDate());
        reserveModel.setGuest(guestRepository.findById(reserveRecordDto.guestId()).get());
        reserveModel.setRoom(roomRepository.findById(reserveRecordDto.roomId()).get());

        RoomModel room = roomRepository.findById(reserveRecordDto.roomId()).get();
        HotelModel hotel = room.getHotel();
        hotel.setAccount(hotel.getAccount() + 100.0);
        hotelRepository.save(hotel);

        return reserveRepository.save(reserveModel);
    }

    public List<ReserveModel> getAll(){
        return reserveRepository.findAll();
    }

    public void delete(Integer id){
        reserveRepository.deleteById(id);
    }

    public ReserveModel update(Integer id, ReserveRecordDto reserveRecordDto){
        ReserveModel reserveModel = reserveRepository.findById(id).get();
        reserveModel.setStartDate(reserveRecordDto.startDate());
        reserveModel.setEndDate(reserveRecordDto.endDate());
        reserveModel.setGuest(guestRepository.findById(reserveRecordDto.guestId()).get());
        reserveModel.setRoom(roomRepository.findById(reserveRecordDto.roomId()).get());
        return reserveRepository.save(reserveModel);
    }
}
