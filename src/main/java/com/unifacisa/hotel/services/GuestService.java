package com.unifacisa.hotel.services;

import com.unifacisa.hotel.dto.GuestRecordDto;
import com.unifacisa.hotel.models.GuestModel;
import com.unifacisa.hotel.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public GuestModel save(GuestRecordDto guestDto) {
        GuestModel guestModel = new GuestModel();
        guestModel.setName(guestDto.name());
        guestModel.setBirthDate(guestDto.birthDate());
        guestModel.setRegistrationDate(LocalDate.now());
        guestModel.setReservations(guestDto.reservations());
        return guestRepository.save(guestModel);
    }

    public List<GuestModel> getAll() {
        return guestRepository.findAll();
    }

    public void delete(Integer id) {
        guestRepository.deleteById(id);
    }

    public GuestModel update(Integer id, GuestRecordDto guestDto) {
        GuestModel guestModel = guestRepository.findById(id).get();
        guestModel.setName(guestDto.name());
        guestModel.setBirthDate(guestDto.birthDate());
        guestModel.setReservations(guestDto.reservations());
        return guestRepository.save(guestModel);
    }
}
