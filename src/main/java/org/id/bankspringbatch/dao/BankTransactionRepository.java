package org.id.bankspringbatch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//springDataRest pour la creation d'une api rest
public interface BankTransactionRepository extends JpaRepository <BankTransaction, Long> {
}

