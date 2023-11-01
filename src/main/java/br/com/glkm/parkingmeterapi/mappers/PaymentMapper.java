package br.com.glkm.parkingmeterapi.mappers;

import br.com.glkm.parkingmeterapi.dtos.ParkingMeterResponseDTO;
import br.com.glkm.parkingmeterapi.dtos.PaymentRequestDTO;
import br.com.glkm.parkingmeterapi.dtos.PaymentResponseDTO;
import br.com.glkm.parkingmeterapi.entities.ParkingMeter;
import br.com.glkm.parkingmeterapi.entities.Payment;

import java.util.UUID;

public abstract class PaymentMapper {
    public static Payment paymentDTOtoPayment(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = new Payment();

        payment.setLicensePlate(paymentRequestDTO.licencePlate());
        payment.setTotalTime(paymentRequestDTO.totalTime());
        payment.setPaidValue(paymentRequestDTO.paidValue());
        payment.setParkingMeter(UUID.fromString(paymentRequestDTO.parkingMeter()));

        return payment;
    };

    public static PaymentResponseDTO paymentToPaymentDTO(Payment payment) {
        return new PaymentResponseDTO(payment.getLicensePlate(), payment.getStartTime(), payment.getTotalTime(), payment.getPaidValue(), payment.getParkingMeter());
    };
}
