package com.devsu.cuenta.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String type;

    @Column(name = "actual_amount")
    private Double actualAmount;

    @Column(name = "first_amount")
    private Double firstAmount;
    private Boolean status;

    @Column(name = "client_id")
    private Long clientId;

    @OneToMany(mappedBy = "accountEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TransactionEntity> transactionList;
}
