package br.com.glkm.parkingmeterapi.services;

import br.com.glkm.parkingmeterapi.dtos.TicketRequestDTO;
import br.com.glkm.parkingmeterapi.entities.Ticket;
import br.com.glkm.parkingmeterapi.mappers.TicketMapper;
import br.com.glkm.parkingmeterapi.repositories.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Transactional(readOnly = true)
    public Page<Ticket> getAllTicket(Pageable pageable){
        return ticketRepository.findAll(pageable);
    };
    @Transactional(readOnly = true)
    public Ticket getTicketById(UUID id){
        return ticketRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ticket not found"));
    }

    public Ticket createTicket(TicketRequestDTO ticketRequestDTO){
        return ticketRepository.save(TicketMapper.ticketDTOtoTicket(ticketRequestDTO));
    }
}
