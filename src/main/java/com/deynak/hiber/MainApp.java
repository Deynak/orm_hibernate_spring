package com.deynak.hiber;

import com.deynak.hiber.config.AppConfig;
import com.deynak.hiber.model.Car;
import com.deynak.hiber.model.User;
import com.deynak.hiber.service.UserService;
import com.deynak.hiber.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        List<User> users = new ArrayList<>();
        users.add(new User("User1", "Lastname1", "user1@mail.ru"));
        users.add(new User("User2", "Lastname2", "user2@mail.ru"));
        users.add(new User("User3", "Lastname3", "user3@mail.ru"));
        users.add(new User("User4", "Lastname4", "user4@mail.ru"));

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Civic", 6));
        cars.add(new Car("M5", 5));
        cars.add(new Car("Model S", 3));
        cars.add(new Car("Corolla", 8));

        for (Car car : cars) {
            carService.add(car);
        }
        for (User user : users) {
            userService.add(user);
        }

        List<User> retrievedUsers = userService.listUsers();
        List<Car> retrievedCars = carService.listCars();

        for (int i = 0; i < retrievedUsers.size(); i++) {
            User user = retrievedUsers.get(i);
            Car car = retrievedCars.get(i % retrievedCars.size());
            user.setUserCars(car);
            userService.add(user);
        }

        List<User> updatedUsers = userService.listUsers();
        for (User user : updatedUsers) {
            System.out.println(user);
        }

        try {
            User foundUser = userService.getUserByCar("Model S", 3);
            System.out.println("Found user: " + foundUser);
        } catch (Exception e) {
            System.out.println("No user found with the specified car model and series.");
        }

        context.close();
    }
}
