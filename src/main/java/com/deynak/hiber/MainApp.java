package com.deynak.hiber;

import com.deynak.hiber.config.AppConfig;
import com.deynak.hiber.model.Car;
import com.deynak.hiber.model.User;
import com.deynak.hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        Car car1 = new Car("Civic", 6);
        user1.setUserCars(car1);
        userService.add(user1);

        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        Car car2 = new Car("M5", 5);
        user2.setUserCars(car2);
        userService.add(user2);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user);
        }

        // Fetch user by car
//        try {
//            User user = userService.getUserByCar("M5", 5);
//            System.out.println("Found user: " + user);
//        } catch (NoResultException e) {
//            System.out.println("No user found with the specified car model and series.");
//        }

        context.close();
    }
}
