package com.devsu.cuenta.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double movement;
    private String type;

    @Column(name = "final_amount")
    private Double finalAmount;
    private LocalDateTime createdOn;

    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AccountEntity accountEntity;
}
