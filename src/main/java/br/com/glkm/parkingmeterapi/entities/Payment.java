package br.com.glkm.parkingmeterapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String licensePlate;

    @Column(nullable = false)
    private Instant startTime;

    @Column(nullable = false)
    private Double totalTime;

    @Column(nullable = false)
    private BigDecimal paidValue;

    @Column(nullable = false)
    private UUID parkingMeter;
}
