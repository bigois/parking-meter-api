package br.com.glkm.parkingmeterapi.services;

import br.com.glkm.parkingmeterapi.dtos.ParkingMeterRequestDTO;
import br.com.glkm.parkingmeterapi.dtos.ParkingMeterResponseDTO;
import br.com.glkm.parkingmeterapi.entities.ParkingMeter;
import br.com.glkm.parkingmeterapi.mappers.ParkingMeterMapper;
import br.com.glkm.parkingmeterapi.repositories.ParkingMeterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class ParkingMeterService {
    @Autowired
    private ParkingMeterRepository parkingMeterRepository;

    @Transactional(readOnly = true)
    public Page<ParkingMeterResponseDTO> getAllParkingMeters(Pageable pageable) {
        Page<ParkingMeter> parkingMeterPage = parkingMeterRepository.findAll(pageable);
        return parkingMeterPage.map(ParkingMeterMapper::parkingMeterToParkingMeterDTO);
    }

    @Transactional(readOnly = true)
    public ParkingMeter getParkingMeterById(UUID id) {
        return parkingMeterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("parking meter not found"));
    }

    @Transactional
    public ParkingMeter createParkingmeter(ParkingMeterRequestDTO parkingMeterRequestDTO) {
        return parkingMeterRepository.save(ParkingMeterMapper.parkingMeterDTOToParkingMeter(parkingMeterRequestDTO));
    }
}
