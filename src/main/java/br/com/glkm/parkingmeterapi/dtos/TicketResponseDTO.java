package br.com.glkm.parkingmeterapi.dtos;

import java.time.Instant;
import java.util.UUID;

public record TicketResponseDTO (
        UUID id,
        Instant endTime,
        UUID payment
){
}
