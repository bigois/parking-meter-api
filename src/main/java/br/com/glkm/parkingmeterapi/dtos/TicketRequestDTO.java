package br.com.glkm.parkingmeterapi.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Pattern;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public record TicketRequestDTO(
        @Future(message = "only future dates")
        Instant endTime,

        @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$", message = "invalid uuid")
        UUID paymentId
) {
}
