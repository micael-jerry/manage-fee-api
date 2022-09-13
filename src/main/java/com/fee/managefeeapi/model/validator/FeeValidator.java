package com.fee.managefeeapi.model.validator;

import com.fee.managefeeapi.model.Fee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

@Component
@AllArgsConstructor
public class FeeValidator {

    public void acceptTypeFee(Fee fee) {
        fee.setType(fee.getType().toUpperCase());
        if(!(fee.getType().equals("TUITION") || fee.getType().equals("HARDWARE"))) {
            throw new InputMismatchException("type "+fee.getType() + " is invalidate");
        }
    }
}
