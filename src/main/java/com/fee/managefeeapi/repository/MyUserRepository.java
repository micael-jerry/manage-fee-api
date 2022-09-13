package com.fee.managefeeapi.repository;

import com.fee.managefeeapi.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

    MyUser findByUsername(String username);

    List<MyUser> findByLastnameContainsIgnoreCaseOrderById(String lastname);

    List<MyUser> findAllByRole(String role);
}
