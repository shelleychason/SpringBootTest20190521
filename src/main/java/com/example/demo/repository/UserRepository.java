package com.example.demo.repository;

import com.example.demo.domain.User;

import java.util.List;

public interface UserRepository {
    User saveOrUpdateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> userList();
}
