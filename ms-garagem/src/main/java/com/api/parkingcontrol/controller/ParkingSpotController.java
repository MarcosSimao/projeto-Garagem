package com.api.parkingcontrol.controller;

import com.api.parkingcontrol.model.entites.ParkingSpot;
import com.api.parkingcontrol.model.dto.ParkingSpotDto;
import com.api.parkingcontrol.service.ParkingSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

;
import javax.validation.Valid;



@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
@RequiredArgsConstructor
public class ParkingSpotController {
     public final ParkingSpotService parkingSpotService;

    @PostMapping
    public ResponseEntity<ParkingSpot> save(@RequestBody ParkingSpotDto parkingSpotDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotDto));
    }

    @GetMapping
    public ResponseEntity<Page<ParkingSpot>>findAll(@PageableDefault (page = 0, size =2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){

        return ResponseEntity.ok().body(parkingSpotService.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object>findById(@PathVariable(value="id") Long id){

        return ResponseEntity.ok().body(parkingSpotService.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        parkingSpotService.delete(id);
        return ResponseEntity.ok().body("deletado com sucesso");
    }

    @PutMapping(value = "/alterar/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id,@RequestBody @Valid ParkingSpotDto
                                         parkingSpotDto){
        System.out.println("Entrou aquillllllllllllllllllllll");
        return ResponseEntity.ok().body(parkingSpotService.update(id,parkingSpotDto));
    }
}
