package com.deynak.hiber.dao;

import com.deynak.hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
