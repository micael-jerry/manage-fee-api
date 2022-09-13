package com.fee.managefeeapi.service;

import com.fee.managefeeapi.model.SchoolYear;
import com.fee.managefeeapi.model.validator.SchoolYearValidator;
import com.fee.managefeeapi.repository.SchoolYearRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class SchoolYearService {
    private SchoolYearRepository schoolYearRepository;
    private SchoolYearValidator schoolYearValidator;

    public List<SchoolYear> getAll() {
        return schoolYearRepository.findAll();
    }

    @Transactional
    public List<SchoolYear> saveAll(List<SchoolYear> schoolYearList) {
        for (SchoolYear schoolYear : schoolYearList) {
            if (!schoolYearValidator.accept(schoolYear)) {
                return new ArrayList<>();
            }
        }
        return schoolYearRepository.saveAll(schoolYearList);
    }

    public SchoolYear getById(int id) {
        return schoolYearRepository.findById(id).get();
    }

    public SchoolYear putById(int id, SchoolYear schoolYear) {
        SchoolYear schoolYear1 = schoolYearRepository.findById(id).get();
        if (schoolYear.getStartYear() != null) {
            schoolYear1.setStartYear(schoolYear.getStartYear());
        }
        if (schoolYear.getEndYear() != null) {
            schoolYear1.setEndYear(schoolYear.getEndYear());
        }
        if (schoolYearValidator.accept(schoolYear1)) {
            return schoolYearRepository.save(schoolYear1);
        } else {
            return new SchoolYear();
        }
    }
}
