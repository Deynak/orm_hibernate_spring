package com.deynak.hiber.service;

import com.deynak.hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
}
