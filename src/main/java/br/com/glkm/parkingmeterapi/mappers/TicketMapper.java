package br.com.glkm.parkingmeterapi.mappers;

import br.com.glkm.parkingmeterapi.dtos.ParkingMeterResponseDTO;
import br.com.glkm.parkingmeterapi.dtos.TicketRequestDTO;
import br.com.glkm.parkingmeterapi.dtos.TicketResponseDTO;
import br.com.glkm.parkingmeterapi.entities.ParkingMeter;
import br.com.glkm.parkingmeterapi.entities.Ticket;

public abstract class TicketMapper {
    public static Ticket ticketDTOtoTicket(TicketRequestDTO ticketRequestDTO) {
        Ticket ticket = new Ticket();

        ticket.setPayment(ticketRequestDTO.paymentId());
        ticket.setEndTime(ticketRequestDTO.endTime());

        return ticket;
    };

    public static TicketResponseDTO ticketToTicketDTO(Ticket ticket) {
        return new TicketResponseDTO(ticket.getId(), ticket.getEndTime(), ticket.getPayment());
    };
}
