package br.com.glkm.parkingmeterapi.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ParkingMeterRequestDTO(
        @Positive(message = "only positive values")
        @NotNull(message = "cannot be null")
        BigDecimal hourValue
) {
}
