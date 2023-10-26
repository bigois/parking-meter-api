package br.com.glkm.parkingmeterapi.repositories;

import br.com.glkm.parkingmeterapi.entities.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    Page<Payment> findAll(Pageable pageable);
}
