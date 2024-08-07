package com.deynak.hiber.dao;

import com.deynak.hiber.model.Car;
import com.deynak.hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    @SuppressWarnings("unchecked")
    public User getUserByCar(String model, int series) {
        String hql = "SELECT user FROM User user WHERE user.userCars.model = :model AND user.userCars.series = :series";
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql, User.class);
        query.setParameter("model", model).setParameter("series", series);
        return query.getSingleResult();
    }

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        sessionFactory.getCurrentSession().createQuery("from Car").list();
        return List.of();
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
