package com.fee.managefeeapi.service;

import com.fee.managefeeapi.model.Transaction;
import com.fee.managefeeapi.model.modelInput.TransactionInput;
import com.fee.managefeeapi.model.validator.TransactionValidator;
import com.fee.managefeeapi.repository.TransactionRepository;
import com.fee.managefeeapi.work.Work;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private TransactionRepository transactionRepository;
    private TransactionValidator transactionValidator;
    private Work work;

    public List<Transaction> getAll(Integer page, Integer size, String date) throws ParseException {
        if (date != null) {
            return this.getByDate(date);
        }
        if (page != null && size != null) {
            return transactionRepository.findAll(PageRequest.of(page, size, Sort.by("date").descending())).toList();
        }
        return transactionRepository.findAll(Sort.by("date").descending());
    }

    public Transaction save(Transaction transaction) {
        transactionValidator.accept(transaction);
        return transactionRepository.save(transaction);
    }

    public Transaction getById(int id) {
        return transactionRepository.findById(id).get();
    }

    public Transaction putById(int id, TransactionInput transaction) {
        Transaction transaction1 = transactionRepository.findById(id).get();
        if (transaction.getDescription() != null) {
            transaction1.setDescription(transaction.getDescription());
        }
        if (transaction.getAmount() > 0) {
            transaction1.setAmount(transaction.getAmount());
        }
        if (transaction.getFee() != null) {
            transaction1.setFee(transaction.getFee());
        }
        return transactionRepository.save(transaction1);
    }

    public List<Transaction> getByFeeId(int id) {
        return transactionRepository.findAllByFee_Id(id);
    }

    public List<Transaction> getByDate(String inputDate) throws ParseException {
        return transactionRepository.findAllByDate(work.convertStringToDate(inputDate));
    }
}
