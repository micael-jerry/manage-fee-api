package com.fee.managefeeapi.repository;


import com.fee.managefeeapi.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeeRepository extends JpaRepository<Fee,Integer> {
    List<Fee> findAllByStudent_Id(int studentId);
    List<Fee> findAllBySchoolYear_Id(int schoolYearId);
}
