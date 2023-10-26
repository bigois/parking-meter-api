package br.com.glkm.parkingmeterapi.repositories;

import br.com.glkm.parkingmeterapi.entities.ParkingMeter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParkingMeterRepository extends JpaRepository<ParkingMeter, UUID> {
    Page<ParkingMeter> findAll(Pageable pageable);
}
