package com.fee.managefeeapi.repository;

import com.fee.managefeeapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findAllByFee_Id(int feeId);

    List<Transaction> findAllByDate(Date date);
}
