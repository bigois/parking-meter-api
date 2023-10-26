package br.com.glkm.parkingmeterapi.controllers;

import br.com.glkm.parkingmeterapi.dtos.TicketRequestDTO;
import br.com.glkm.parkingmeterapi.dtos.TicketResponseDTO;
import br.com.glkm.parkingmeterapi.services.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(name = "/api/v1/tickets", produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {

    @Autowired
    private TicketService ticketService;

    /*@GetMapping
    public ResponseEntity<Page<TicketResponseDTO>> getAllTickets(Pageable pageable){
        Page<TicketResponseDTO> tickets = ticketService.getAllTicket(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(tickets);
    }*/

   @GetMapping("/{id}")
    public ResponseEntity<TicketRequestDTO> getTicket(@PathVariable @Valid UUID id) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    public ResponseEntity<TicketRequestDTO> registerParkingMeter(@RequestBody @Valid TicketRequestDTO ticketRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketRequestDTO);
    }
}
