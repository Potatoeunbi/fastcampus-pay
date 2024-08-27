package com.fastcampuspay.money.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRegisteredBankRepository extends JpaRepository<RegisteredBankAccountJpaEntity, Long> {
    RegisteredBankAccountJpaEntity findByBankAccountNumber(String bankAccountNumber);
}
