package com.unifacisa.hotel.controller;

import com.unifacisa.hotel.dto.GuestRecordDto;
import com.unifacisa.hotel.models.GuestModel;
import com.unifacisa.hotel.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public List<GuestModel> getAllGuests() {
        return guestService.getAll();
    }

    @PostMapping
    public GuestModel saveGuest(@RequestBody GuestRecordDto guest) {
        return guestService.save(guest);
    }

    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable Integer id) {
        guestService.delete(id);
    }

    @PutMapping("/{id}")
    public GuestModel updateGuest(@PathVariable Integer id, @RequestBody GuestRecordDto guest) {
        return guestService.update(id, guest);
    }

}
