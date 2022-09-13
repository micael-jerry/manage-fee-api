package com.fee.managefeeapi.model.validator;

import com.fee.managefeeapi.model.Transaction;
import com.fee.managefeeapi.repository.FeeRepository;
import com.fee.managefeeapi.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;

@Component
@AllArgsConstructor
public class TransactionValidator {
    private FeeRepository feeRepository;
    private TransactionRepository transactionRepository;

    public void accept(Transaction transaction) {
        if (transaction.getAmount() < 0) {
            throw new InputMismatchException("AMOUNT < 0");
        }
        List<Transaction> transactionList = transactionRepository.findAllByFee_Id(transaction.getFee().getId());
        int sum = 0;
        for (Transaction transaction1 : transactionList) {
            sum += transaction1.getAmount();
        }
        if (feeRepository.findById(transaction.getFee().getId()).get().getTotalAmount() < transaction.getAmount() + sum) {
            throw new InputMismatchException("AMOUNT EXPECTED");
        }
    }
}
