package br.com.glkm.parkingmeterapi.mappers;

import br.com.glkm.parkingmeterapi.dtos.ParkingMeterRequestDTO;
import br.com.glkm.parkingmeterapi.dtos.ParkingMeterResponseDTO;
import br.com.glkm.parkingmeterapi.entities.ParkingMeter;

public abstract class ParkingMeterMapper {
    public static ParkingMeter parkingMeterDTOToParkingMeter(ParkingMeterRequestDTO parkingMeterRequestDTO) {
        ParkingMeter parkingMeter = new ParkingMeter();
        parkingMeter.setHourValue(parkingMeterRequestDTO.hourValue());
        return parkingMeter;
    };

    public static ParkingMeterResponseDTO parkingMeterToParkingMeterDTO(ParkingMeter parkingMeter) {
        return new ParkingMeterResponseDTO(parkingMeter.getId(), parkingMeter.getHourValue());
    };
}
