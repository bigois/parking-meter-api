package br.com.glkm.parkingmeterapi.services;

import br.com.glkm.parkingmeterapi.dtos.TicketRequestDTO;
import br.com.glkm.parkingmeterapi.dtos.TicketResponseDTO;
import br.com.glkm.parkingmeterapi.entities.Payment;
import br.com.glkm.parkingmeterapi.entities.Ticket;
import br.com.glkm.parkingmeterapi.mappers.TicketMapper;
import br.com.glkm.parkingmeterapi.repositories.PaymentRepository;
import br.com.glkm.parkingmeterapi.repositories.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional(readOnly = true)
    public Page<TicketResponseDTO> getAllTickets (Pageable pageable){
        Page<Ticket> ticketPage = ticketRepository.findAll(pageable);
        return ticketPage.map(TicketMapper::ticketToTicketDTO);
    };

    @Transactional(readOnly = true)
    public Ticket getTicketById(UUID id){
        return ticketRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ticket not found"));
    }

    @Transactional(readOnly = true)
    public Ticket createTicket(UUID id){
        Payment payment =  paymentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("payment not found"));
        Instant initialHour = payment.getStartTime();

        Duration duasHoras = Duration.ofHours(payment.getTotalTime().longValue());

        Instant endHour = initialHour.plus(duasHoras);

        TicketRequestDTO ticketRequestDTO = new TicketRequestDTO(endHour, payment.getId());
        return ticketRepository.save(TicketMapper.ticketDTOtoTicket(ticketRequestDTO));
    }
}
