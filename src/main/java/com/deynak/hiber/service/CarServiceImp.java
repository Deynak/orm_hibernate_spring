package com.deynak.hiber.service;

import com.deynak.hiber.dao.CarDao;
import com.deynak.hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars() {
        return carDao.listCars();
    }

    @Transactional(readOnly = true)
    @Override
    public Car getCarByModelAndSeries(String model, int series) {
        return carDao.getCarByModelAndSeries(model, series);
    }
}
