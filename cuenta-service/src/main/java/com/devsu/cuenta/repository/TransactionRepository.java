package com.devsu.cuenta.repository;

import com.devsu.cuenta.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {
    Optional<TransactionEntity> findFirstByAccountEntity_NumberOrderByCreatedOnDesc(String accountNumber);

    @Query("SELECT t FROM TransactionEntity t WHERE t.accountEntity.clientId = :id AND t.createdOn BETWEEN :startDate AND :endDate ORDER BY t.createdOn DESC")
    List<TransactionEntity> getTransactionsBetweenDates(@RequestParam("id") Long id, @RequestParam("startDate") LocalDateTime startDate, @RequestParam("endDate")LocalDateTime endDate);
}
