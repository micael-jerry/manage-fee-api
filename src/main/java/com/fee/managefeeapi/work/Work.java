package com.fee.managefeeapi.work;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@NoArgsConstructor
public class Work {
    public Date convertStringToDate(String inputDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(inputDate);
    }
}
