package com.fee.managefeeapi.service;

import com.fee.managefeeapi.model.MyUser;
import com.fee.managefeeapi.model.validator.MyUserValidator;
import com.fee.managefeeapi.repository.MyUserRepository;
import com.fee.managefeeapi.work.Work;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

@Service
@AllArgsConstructor
public class MyUserService {
    private MyUserRepository myUserRepository;
    private Work work;
    private MyUserValidator myUserValidator;

    @Transactional
    public ResponseEntity<List<MyUser>> saveAll(List<MyUser> myUserList) {
        List<MyUser> accepted = new ArrayList<>();
        for (MyUser myUser : myUserList) {
            if (myUserValidator.acceptRole(myUser)) {
                accepted.add(myUser);
            } else {
                return ResponseEntity
                        .badRequest()
                        .header("ERROR", "role:" + myUser.getRole() + "in id:" + myUser.getId() + " does not exist")
                        .body(null);
            }
            if (myUser.getPassword() != null) {
                myUser.setPassword(passwordEncoder().encode(myUser.getPassword()));
            }
            try {
                if (work.convertStringToDate(myUser.getBirthDate()).after(new Date())) {
                    return ResponseEntity
                            .badRequest()
                            .header("ERROR", "birthDate < new date in myUser id: " + myUser.getId())
                            .body(null);
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return ResponseEntity
                .ok()
                .body(this.changeRefList(myUserRepository.saveAll(accepted)));
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public List<MyUser> getAll(Integer page, Integer size) {
        if (page != null && size != null) {
            return this.changeRefList(
                    myUserRepository.findAll(
                            PageRequest.of(page, size, Sort.by("id").ascending())
                    ).toList()
            );
        }
        return this.changeRefList(myUserRepository.findAll());
    }

    public MyUser getUserById(int id) {
        return this.changeRef(myUserRepository.findById(id).get());
    }

    public MyUser updateUserById(int id, MyUser myUser) {
        MyUser oldMyUser = myUserRepository.findById(id).get();
        if (myUser.getLastname() != null) {
            oldMyUser.setLastname(myUser.getLastname());
        }
        if (myUser.getFirstname() != null) {
            oldMyUser.setFirstname(myUser.getFirstname());
        }
        if (myUser.getUsername() != null) {
            oldMyUser.setUsername(myUser.getUsername());
        }
        if (myUser.getPassword() != null) {
            oldMyUser.setPassword(passwordEncoder().encode(myUser.getPassword()));
        }
        if (myUser.getGroups() != null) {
            oldMyUser.setGroups(myUser.getGroups());
        }
        return this.changeRef(myUserRepository.save(oldMyUser));
    }

    public void deleteUser(int id) {
        myUserRepository.deleteById(id);
    }

    public ResponseEntity<List<MyUser>> getUsersByRole(String role) {
        role = role.toLowerCase();
        if (role.equals("student") || role.equals("teacher") || role.equals("manager")) {
            return ResponseEntity
                    .ok()
                    .body(this.changeRefList(myUserRepository.findAllByRole(role)));
        }
        throw new InputMismatchException("role:" + role + " does not exist");
    }

    public MyUser changeRef(MyUser myUser) {
        String startRef = switch (myUser.getRole()) {
            case "student" -> "STD";
            case "teacher" -> "TCH";
            case "manager" -> "MNG";
            default -> "";
        };
        myUser.setRef(startRef + "0".repeat(Math.max(0, 3 - (String.valueOf(myUser.getId()).length()))) + myUser.getId());
        return myUser;
    }

    public List<MyUser> changeRefList(List<MyUser> myUserList) {
        List<MyUser> changed = new ArrayList<>();
        for (MyUser myUser : myUserList) {
            changed.add(this.changeRef(myUser));
        }
        return changed;
    }
}
