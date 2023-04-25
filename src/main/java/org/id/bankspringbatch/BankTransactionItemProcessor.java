package org.id.bankspringbatch;

import org.id.bankspringbatch.dao.BankTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


//@Component
//On l'extentie plutôt dans la méthode ItemProcessor1
public class BankTransactionItemProcessor implements ItemProcessor<BankTransaction, BankTransaction> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
    @Override
    public BankTransaction process(BankTransaction item) throws Exception {
        item.setTransactionDate(dateFormat.parse(item.getStrTransactionDate()));
        return item;
    }
}
