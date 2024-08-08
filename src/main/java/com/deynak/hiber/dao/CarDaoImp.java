package com.deynak.hiber.dao;

import com.deynak.hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    @SuppressWarnings("unchecked")
    public Car getCarByModelAndSeries(String model, int series) {
        String hql = "FROM Car WHERE model = :model AND series = :series";
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery(hql, Car.class);
        query.setParameter("model", model).setParameter("series", series);
        return query.getSingleResult();
    }
}
