package com.fee.managefeeapi.controller;

import com.fee.managefeeapi.model.SchoolYear;
import com.fee.managefeeapi.service.SchoolYearService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(value = "/school-year")
public class SchoolYearController {
    private SchoolYearService schoolYearService;

    @GetMapping(value = "")
    public List<SchoolYear> getAll() {
        return schoolYearService.getAll();
    }

    @PostMapping(value = "")
    public List<SchoolYear> saveAll(@RequestBody List<SchoolYear> schoolYearList) {
        return schoolYearService.saveAll(schoolYearList);
    }

    @GetMapping(value = "/{id}")
    public SchoolYear getById(@PathVariable int id) {
        return schoolYearService.getById(id);
    }

    @PutMapping(value = "/{id}")
    public SchoolYear putById(@PathVariable int id, @RequestBody SchoolYear schoolYear) {
        return schoolYearService.putById(id, schoolYear);
    }
}
