package com.unifacisa.hotel.controller;

import com.unifacisa.hotel.dto.RoomRecordDto;
import com.unifacisa.hotel.models.RoomModel;
import com.unifacisa.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<RoomModel> getAllRooms() {
        return roomService.getAll();
    }

    @PostMapping
    public RoomModel saveRoom(@RequestBody RoomRecordDto room) {
        return roomService.save(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Integer id) {
        roomService.delete(id);
    }

    @PutMapping("/{id}")
    public RoomModel updateRoom(@PathVariable Integer id, @RequestBody RoomRecordDto room) {
        return roomService.update(id, room);
    }


}
