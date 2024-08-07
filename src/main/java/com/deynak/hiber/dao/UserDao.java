package com.deynak.hiber.dao;

import com.deynak.hiber.model.Car;
import com.deynak.hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User getUserByCar(String model, int series);

    void addCar(Car car);

    List<Car> listCars();

    Car getCarByModelAndSeries(String model, int series);
}
