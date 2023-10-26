package br.com.glkm.parkingmeterapi.dtos;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record PaymentResponseDTO(
        String licencePlate,
        Instant startTime,
        Double totalTime,
        BigDecimal paidValue,
        UUID parkingMeter
) {
}
