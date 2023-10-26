package br.com.glkm.parkingmeterapi.controllers;

import br.com.glkm.parkingmeterapi.dtos.ParkingMeterRequestDTO;
import br.com.glkm.parkingmeterapi.dtos.ParkingMeterResponseDTO;
import br.com.glkm.parkingmeterapi.entities.ParkingMeter;
import br.com.glkm.parkingmeterapi.mappers.ParkingMeterMapper;
import br.com.glkm.parkingmeterapi.services.ParkingMeterService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/parkingmeters", produces = MediaType.APPLICATION_JSON_VALUE)
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class ParkingMeterController {
    @Autowired
    private ParkingMeterService parkingMeterService;

    @GetMapping
    public ResponseEntity<Page<ParkingMeterResponseDTO>> getAllParkingMeters(Pageable pageable) {
        Page<ParkingMeterResponseDTO> parkingMeters = parkingMeterService.getAllParkingMeters(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(parkingMeters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingMeterResponseDTO> getParkingMeter(@PathVariable @Valid UUID id) {
        ParkingMeter parkingMeter = parkingMeterService.getParkingMeterById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ParkingMeterMapper.parkingMeterToParkingMeterDTO(parkingMeter));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerParkingMeter(@RequestBody @Valid ParkingMeterRequestDTO parkingMeterRequestDTO) {
        ParkingMeter parkingMeter = parkingMeterService.createParkingmeter(parkingMeterRequestDTO);

        JSONObject response = new JSONObject();
        response.put("id", parkingMeter.getId());
        response.put("message", "parking meter successfully registered");

        return ResponseEntity.status(HttpStatus.CREATED).body(response.toString());
    }
}
