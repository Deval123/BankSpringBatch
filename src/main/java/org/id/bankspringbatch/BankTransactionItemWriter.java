package org.id.bankspringbatch;

import org.id.bankspringbatch.dao.BankTransaction;
import org.id.bankspringbatch.dao.BankTransactionRepository;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankTransactionItemWriter implements ItemWriter <BankTransaction> {
    private final BankTransactionRepository bankTransactionRepository;

    public BankTransactionItemWriter(BankTransactionRepository bankTransactionRepository) {
        this.bankTransactionRepository = bankTransactionRepository;
    }

    @Override
    public void write(List<? extends BankTransaction> list){
        bankTransactionRepository.saveAll(list);
    }
}
