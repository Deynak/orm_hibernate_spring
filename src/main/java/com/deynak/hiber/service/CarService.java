package com.deynak.hiber.service;

import com.deynak.hiber.model.Car;

import java.util.List;

public interface CarService {
    void add(Car car);

    List<Car> listCars();

    Car getCarByModelAndSeries(String model, int series);
}
