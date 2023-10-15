package com.devsu.cliente.repository;

import com.devsu.cliente.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByPersonEntityDocumentNumber(String documentNumber);
}
