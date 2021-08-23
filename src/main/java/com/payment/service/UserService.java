package com.payment.service;

import com.payment.model.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
    User pay(User user);
    User withdraw(User user);
}
