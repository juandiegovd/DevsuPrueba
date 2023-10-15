package com.devsu.cuenta.repository;

import com.devsu.cuenta.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    Optional<AccountEntity> findByNumberEquals(String accountNumber);
    List<AccountEntity> findByClientId(int id);

    @Query("update AccountEntity ac SET ac.status = false WHERE ac.number = :accountNumber")
    @Modifying
    @Transactional
    void deleteAccountLogically(@Param("accountNumber") String accountNumber);
}
