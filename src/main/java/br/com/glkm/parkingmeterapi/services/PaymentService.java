package br.com.glkm.parkingmeterapi.services;

import br.com.glkm.parkingmeterapi.dtos.PaymentRequestDTO;
import br.com.glkm.parkingmeterapi.entities.Payment;
import br.com.glkm.parkingmeterapi.mappers.PaymentMapper;
import br.com.glkm.parkingmeterapi.repositories.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional(readOnly = true)
    public Payment getPaymentById(UUID id) {
        return paymentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("payment not found"));
    };

    @Transactional
    public Payment createPayment(PaymentRequestDTO paymentRequestDTO) {
        return paymentRepository.save(PaymentMapper.paymentDTOtoPayment(paymentRequestDTO));
    };
}
