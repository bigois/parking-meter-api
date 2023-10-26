package br.com.glkm.parkingmeterapi.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record ParkingMeterResponseDTO(
        UUID id,
        BigDecimal hourValue
) {
}
