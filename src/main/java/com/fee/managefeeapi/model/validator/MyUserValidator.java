package com.fee.managefeeapi.model.validator;

import com.fee.managefeeapi.model.MyUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MyUserValidator {

    public boolean acceptRole(MyUser myUser) {
        return myUser.getRole().equals("student") || myUser.getRole().equals("teacher") || myUser.getRole().equals("manager");
    }
}
