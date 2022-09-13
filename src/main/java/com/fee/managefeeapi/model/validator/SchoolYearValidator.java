package com.fee.managefeeapi.model.validator;

import com.fee.managefeeapi.model.SchoolYear;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
@Slf4j
public class SchoolYearValidator {

    public boolean accept(SchoolYear schoolYear) {
        if (new Date(Integer.parseInt(schoolYear.getStartYear())).getYear() > new Date(Integer.parseInt(schoolYear.getEndYear())).getYear()) {
            log.error("START YEAR > END DATE"+ schoolYear.getStartYear() + "<"+ new Date().getYear());
            return false;
        }
        return true;
    }
}
