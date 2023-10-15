package com.devsu.cliente.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "document_number")
    private String documentNumber;

    private String name;
    private String gender;
    private String age;
    private String address;
    private String phone;
}
