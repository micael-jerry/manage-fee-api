package com.fee.managefeeapi.controller;

import com.fee.managefeeapi.model.Transaction;
import com.fee.managefeeapi.model.modelInput.TransactionInput;
import com.fee.managefeeapi.repository.TransactionRepository;
import com.fee.managefeeapi.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/transaction")
public class TransactionController {
    private TransactionService transactionService;

    @GetMapping(value = "")
    public List<Transaction> getAllTransaction(
            @RequestParam(name = "page",required = false) Integer page,
            @RequestParam(name = "size",required = false) Integer size,
            @RequestParam(name = "date",required = false) String date
    ) throws ParseException {
        return transactionService.getAll(page, size, date);
    }

    @PostMapping(value = "")
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }

    @GetMapping(value = "/{id}")
    public Transaction getTransactionById(@PathVariable int id) {
        return transactionService.getById(id);
    }

    @PutMapping(value = "/{id}")
    public Transaction putTransactionById(@PathVariable int id, @RequestBody TransactionInput transaction) {
        return transactionService.putById(id, transaction);
    }

    @GetMapping(value = "/fee/{feeId}")
    public List<Transaction> getByFeeId(@PathVariable int feeId) {
        return transactionService.getByFeeId(feeId);
    }
}
