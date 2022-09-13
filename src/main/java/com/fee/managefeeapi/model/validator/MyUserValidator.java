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
        if (!myUser.getRole().equals("student") && !myUser.getRole().equals("teacher") && !myUser.getRole().equals("manager")) {
            throw new InputMismatchException("role: " + myUser.getRole() + " in id:" + myUser.getId() + " does not exist. (student,teacher,manager)");
        }
        if(!myUser.getSex().equals("M") && !myUser.getSex().equals("F")) {
            throw new InputMismatchException("sex: " + myUser.getSex() + " in id:"+ myUser.getId() + " does not exist. (M,F)");
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
