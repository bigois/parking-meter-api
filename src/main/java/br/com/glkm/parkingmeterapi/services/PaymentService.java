package br.com.glkm.parkingmeterapi.services;

import br.com.glkm.parkingmeterapi.dtos.PaymentRequestDTO;
import br.com.glkm.parkingmeterapi.entities.ParkingMeter;
import br.com.glkm.parkingmeterapi.entities.Payment;
import br.com.glkm.parkingmeterapi.repositories.ParkingMeterRepository;
import br.com.glkm.parkingmeterapi.repositories.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ParkingMeterRepository parkingMeterRepository;

    @Autowired
    private TicketService ticketService;

    @Transactional(readOnly = true)
    public Payment getPaymentById(UUID id) {
        return paymentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("payment not found"));
    };

    @Transactional
    public Payment createPayment(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = new Payment();
        ParkingMeter parkingMeter = parkingMeterRepository.findById(UUID.fromString(paymentRequestDTO.parkingMeter())).orElseThrow(() -> new EntityNotFoundException("parking meter not found"));

        Instant initialHour = Instant.now();

        BigDecimal totalValue = parkingMeter.getHourValue().multiply(BigDecimal.valueOf(paymentRequestDTO.totalTime()));

        payment.setLicensePlate(paymentRequestDTO.licencePlate());
        payment.setStartTime(initialHour);
        payment.setTotalTime(paymentRequestDTO.totalTime());
        payment.setPaidValue(totalValue);
        payment.setParkingMeter(UUID.fromString(paymentRequestDTO.parkingMeter()));

        return paymentRepository.save(payment);
    };
}
