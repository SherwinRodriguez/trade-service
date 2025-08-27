package com.rtsrms.trade_service.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Entity
@Table(name = "trades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private String assetType;

    @Column(nullable = false)
    private String assetName;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String status;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

}
