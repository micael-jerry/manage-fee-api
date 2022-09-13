package com.fee.managefeeapi.model.validator;

import com.fee.managefeeapi.model.MyUser;
import com.fee.managefeeapi.work.Work;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;

@Component
@AllArgsConstructor
public class MyUserValidator {
    private Work work;

    public void accept(MyUser myUser) {
        if (!myUser.getRole().equals("student") || !myUser.getRole().equals("teacher") || !myUser.getRole().equals("manager")) {
            throw new InputMismatchException("role:" + myUser.getRole() + "in id:" + myUser.getId() + " does not exist");
        }
        try {
            if (work.convertStringToDate(myUser.getBirthDate()).after(new Date())) {
                throw new InputMismatchException("birthDate < new date in myUser id: " + myUser.getId());
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
