package com.deynak.hiber.dao;

import com.deynak.hiber.model.User;
import com.deynak.hiber.model.Car;
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

    @Autowired
    private CarDao carDao;

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
        Car car = carDao.getCarByModelAndSeries(model, series);
        String hql = "SELECT user FROM User user WHERE user.userCars = :car";
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql, User.class);
        query.setParameter("car", car);
        return query.getSingleResult();
    }
}
