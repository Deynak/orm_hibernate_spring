package com.deynak.hiber.dao;

import com.deynak.hiber.model.Car;

import java.util.List;

public interface CarDao {

    public void add(Car car);

    public List<Car> listCars();

    public Car getCarByModelAndSeries(String model, int series);
}
