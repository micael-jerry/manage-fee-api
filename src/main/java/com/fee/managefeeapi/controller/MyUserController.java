package com.fee.managefeeapi.controller;

import com.fee.managefeeapi.model.MyUser;
import com.fee.managefeeapi.service.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
@CrossOrigin(origins = "*")
public class MyUserController {
    private MyUserService myUserService;

    @PostMapping(value = "")
    public ResponseEntity<List<MyUser>> createUser(@RequestBody List<MyUser> myUserList) {
        return myUserService.saveAll(myUserList);
    }

    @GetMapping(value = "")
    public List<MyUser> getUsers(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "size", required = false) Integer size,
            @RequestParam(name = "lastname", required = false) String lastname
    ) {
        return myUserService.getAll(page, size, lastname);
    }

    @GetMapping(value = "/role/{role}")
    public ResponseEntity<List<MyUser>> getUsersByRole(@PathVariable String role) {
        return myUserService.getUsersByRole(role);
    }

    @GetMapping(value = "/{id}")
    public MyUser getUser(@PathVariable int id) {
        return myUserService.getUserById(id);
    }

    @PutMapping(value = "/{id}")
    public MyUser putUser(@PathVariable int id, @RequestBody MyUser myUser) {
        return myUserService.updateUserById(id, myUser);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        myUserService.deleteUser(id);
    }
}
