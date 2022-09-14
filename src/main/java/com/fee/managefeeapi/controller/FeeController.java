package com.fee.managefeeapi.controller;

import com.fee.managefeeapi.model.Fee;
import com.fee.managefeeapi.service.FeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/fees")
public class FeeController {
    private FeeService feeService;

    @GetMapping(value = "")
    public List<Fee> getAllFee(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "size", required = false) Integer size,
            @RequestParam(name = "type", required = false) String type,
            @RequestParam(name = "lastname", required = false) String lastname,
            @RequestParam(name = "student-id", required = false) Integer studentId
    ) {
        return feeService.getAll(page, size, type, lastname, studentId);
    }

    @PostMapping(value = "")
    public List<Fee> saveAllFee(@RequestBody List<Fee> feeList) {
        return feeService.saveAll(feeList);
    }

    @GetMapping(value = "/{id}")
    public Fee getFeeById(@PathVariable int id) {
        return feeService.getById(id);
    }

    @PutMapping(value = "/{id}")
    public Fee putFeeById(@PathVariable int id, @RequestBody Fee fee) {
        return feeService.putById(id, fee);
    }

    @GetMapping(value = "/student/{studentId}")
    public List<Fee> getFeeByStudentId(@PathVariable int studentId) {
        return feeService.getByStudentId(studentId);
    }
}
