package br.com.glkm.parkingmeterapi.controllers;

import br.com.glkm.parkingmeterapi.dtos.TicketRequestDTO;
import br.com.glkm.parkingmeterapi.dtos.TicketResponseDTO;
import br.com.glkm.parkingmeterapi.services.TicketService;
import br.com.glkm.parkingmeterapi.entities.Ticket;
import br.com.glkm.parkingmeterapi.mappers.TicketMapper;
import br.com.glkm.parkingmeterapi.repositories.TicketRepository;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tickets", produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<Page<TicketResponseDTO>> getAllTickets(Pageable pageable){
        Page<TicketResponseDTO> tickets = ticketService.getAllTickets(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(tickets);
    }

   @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> getTicket(@PathVariable @Valid UUID id) {
        Ticket ticket = ticketService.getTicketById(id);
        return ResponseEntity.status(HttpStatus.OK).body(TicketMapper.ticketToTicketDTO(ticket));
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> registerTicket(@PathVariable @Valid UUID id) {
        Ticket ticket = ticketService.createTicket(id);

        JSONObject response = new JSONObject();
        response.put("id", ticket.getId());
        response.put("endTime", ticket.getEndTime());
        response.put("payment", ticket.getPayment());
        response.put("message", "Ticket successfully created");

        return ResponseEntity.status(HttpStatus.CREATED).body(response.toString());
    }
}
