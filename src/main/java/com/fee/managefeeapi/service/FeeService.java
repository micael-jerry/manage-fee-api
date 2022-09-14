package com.fee.managefeeapi.service;

import com.fee.managefeeapi.model.Fee;
import com.fee.managefeeapi.model.Transaction;
import com.fee.managefeeapi.model.validator.FeeValidator;
import com.fee.managefeeapi.repository.FeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FeeService {
    private FeeRepository feeRepository;
    private TransactionService transactionService;
    private FeeValidator feeValidator;

    public List<Fee> getAll(Integer page, Integer size, String type, String lastname, Integer studentId) {
        if(studentId != null) {
            return this.findByStudentId(page,size,studentId);
        }
        if (type != null) {
            return this.findByType(page, size, type);
        }
        if (lastname != null) {
            return this.findByStudentLastName(page, size, lastname);
        }
        if (page != null && size != null) {
            return this.changeRemainingAmountList(
                    feeRepository.findAll(PageRequest.of(page, size)).toList()
            );
        }
        return this.changeRemainingAmountList(feeRepository.findAll());
    }

    public List<Fee> findByType(Integer page, Integer size, String type) {
        if (page != null && size != null) {
            return this.changeRemainingAmountList(feeRepository.findAllByType(type, PageRequest.of(page, size)));
        }
        return this.changeRemainingAmountList(feeRepository.findAllByType(type));
    }

    public List<Fee> findByStudentId(Integer page, Integer size, Integer id) {
        if (page != null && size != null) {
            return this.changeRemainingAmountList(feeRepository.findAllByStudent_Id(id, PageRequest.of(page, size)));
        }
        return this.changeRemainingAmountList(feeRepository.findAllByStudent_Id(id));
    }

    public List<Fee> findByStudentLastName(Integer page, Integer size, String lastname) {
        if (page != null && size != null) {
            return this.changeRemainingAmountList(feeRepository.findAllByStudentLastname(lastname, PageRequest.of(page, size)));
        }
        return this.changeRemainingAmountList(feeRepository.findAllByStudentLastname(lastname));
    }

    @Transactional
    public List<Fee> saveAll(List<Fee> feeList) {
        for (Fee fee : feeList) {
            feeValidator.acceptTypeFee(fee);
        }
        return feeRepository.saveAll(feeList);
    }

    public Fee getById(int id) {
        return this.changeRemainingAmount(
                feeRepository.findById(id).get()
        );
    }

    public List<Fee> getByStudentId(int studentId) {
        return feeRepository.findAllByStudent_Id(studentId);
    }

    public List<Fee> getBySchoolYearId(int schoolYearId) {
        return feeRepository.findAllBySchoolYear_Id(schoolYearId);
    }

    public Fee putById(int id, Fee fee) {
        Fee oldFee = feeRepository.findById(id).get();
        if (fee.getType() != null) {
            feeValidator.acceptTypeFee(fee);
            oldFee.setType(fee.getType());
        }
        if (fee.getDescription() != null) {
            oldFee.setDescription(fee.getDescription());
        }
        if (fee.getTotalAmount() != 0) {
            oldFee.setTotalAmount(fee.getTotalAmount());
        }
        if (fee.getStudent() != null) {
            oldFee.setStudent(fee.getStudent());
        }
        if (fee.getSchoolYear() != null) {
            oldFee.setSchoolYear(fee.getSchoolYear());
        }
        return feeRepository.save(oldFee);
    }

    public List<Fee> changeRemainingAmountList(List<Fee> feeList) {
        List<Fee> fees = new ArrayList<>();
        for (Fee fee : feeList) {
            fees.add(this.changeRemainingAmount(fee));
        }
        return fees;
    }

    public Fee changeRemainingAmount(Fee fee) {
        List<Transaction> transactionList = transactionService.getByFeeId(fee.getId());
        int sum = 0;
        for (Transaction transaction : transactionList) {
            sum += transaction.getAmount();
        }
        fee.setRemainingAmount(fee.getTotalAmount() - sum);
        return fee;
    }
}
