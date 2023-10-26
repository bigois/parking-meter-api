package br.com.glkm.parkingmeterapi.repositories;

import br.com.glkm.parkingmeterapi.entities.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    Page<Ticket> findAll(Pageable pageable);
}
