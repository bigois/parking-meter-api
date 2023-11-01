package br.com.glkm.parkingmeterapi.dtos;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record PaymentRequestDTO(
        @NotBlank(message = "cannot be null")
        @Pattern(regexp = "^([A-Z]{3}-\\d[A-Z]\\d{2}|[A-Z]{3}-\\d{4})$", message = "not valid")
        String licencePlate,

        @NotNull(message = "cannot be null")
        @Positive(message = "only positive values")
        Double totalTime,

        @NotNull(message = "cannot be null")
        @Positive(message = "only positive values")
        BigDecimal paidValue,

        @NotBlank(message = "cannot be null")
        @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$", message = "not valid")
        String parkingMeter
) {
}
