package com.unifacisa.hotel.controller;

import com.unifacisa.hotel.dto.ReserveRecordDto;
import com.unifacisa.hotel.models.ReserveModel;
import com.unifacisa.hotel.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

    private final ReserveService reserveService;

    @Autowired
    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @GetMapping
    public List<ReserveModel> getAllReserves(){
        return reserveService.getAll();
    }

    @PostMapping
    public ReserveModel saveReserve(@RequestBody ReserveRecordDto reserve){
        return reserveService.save(reserve);
    }

    @DeleteMapping("/{id}")
    public void deleteReserve(@PathVariable Integer id){
        reserveService.delete(id);
    }

    @PutMapping("/{id}")
    public ReserveModel updateReserve(@PathVariable Integer id, @RequestBody ReserveRecordDto reserve){
        return reserveService.update(id, reserve);
    }
}
