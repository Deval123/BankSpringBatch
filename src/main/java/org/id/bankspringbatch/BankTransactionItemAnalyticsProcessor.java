package org.id.bankspringbatch;

import lombok.Getter;
import org.id.bankspringbatch.dao.BankTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


//@Component
//On l'extentie plutôt dans la méthode ItemProcessor2

public class BankTransactionItemAnalyticsProcessor implements ItemProcessor<BankTransaction, BankTransaction> {

    @Getter
    private double totalDebit;
    @Getter
    private double totalCredit;
    @Override
    public BankTransaction process(BankTransaction item){
        if(item.getTransactionType().equals("D")) totalDebit+=item.getAmount();
        else if(item.getTransactionType().equals("C")) totalCredit+=item.getAmount();
        return item;
    }
}
