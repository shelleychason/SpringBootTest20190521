package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
//    User saveOrUpdateUser(User user);
//
//    void deleteUser(Long id);
//
//    User getUserById(Long id);
//
//    List<User> userList();
}
