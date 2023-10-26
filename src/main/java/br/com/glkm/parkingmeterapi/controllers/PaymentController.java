package br.com.glkm.parkingmeterapi.controllers;

import br.com.glkm.parkingmeterapi.dtos.PaymentRequestDTO;
import br.com.glkm.parkingmeterapi.dtos.PaymentResponseDTO;
import br.com.glkm.parkingmeterapi.entities.Payment;
import br.com.glkm.parkingmeterapi.mappers.PaymentMapper;
import br.com.glkm.parkingmeterapi.services.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/payments", produces = MediaType.APPLICATION_JSON_VALUE)
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> getPayment(@PathVariable @Valid UUID id) {
        Payment payment = paymentService.getPaymentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(PaymentMapper.paymentToPaymentDTO(payment));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerPayment(@RequestBody @Valid PaymentRequestDTO paymentRequestDTO) {
        Payment payment = paymentService.createPayment(paymentRequestDTO);

        JSONObject response = new JSONObject();
        response.put("id", payment.getId());
        response.put("message", "parking meter successfully registered");

        return ResponseEntity.status(HttpStatus.CREATED).body(response.toString());
    }
}
