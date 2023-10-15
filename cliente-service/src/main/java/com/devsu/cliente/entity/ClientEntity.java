package com.devsu.cliente.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private Boolean status;

    @JoinColumn(name = "personId", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PersonEntity personEntity;
}
