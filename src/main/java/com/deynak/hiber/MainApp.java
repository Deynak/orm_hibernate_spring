package com.deynak.hiber;

import com.deynak.hiber.config.AppConfig;
import com.deynak.hiber.model.Car;
import com.deynak.hiber.model.User;
import com.deynak.hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//
//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println();
//        }
//        User Zaur = new User("Zaur", "Tregulov", "VIvanov@mail.ru");
//        User Dima = new User("Dima", "Fedorovich", "DimaFedorovich@mail.ru");
//        User Anna = new User("Anna", "Zelman", "AnnZelman@mail.ru");
//        User Masha = new User("Masha", "Shelest", "Shelestmash@mail.ru");
//
//        Car honda = new Car("Civic", 6);
//        Car BMV = new Car("M5", 5);
//        Car Mers = new Car("mers", 8);
//        Car Lada = new Car("vag", 7);
//
//        Masha.setUserCars(honda);
//        userService.add(Masha);
//        Zaur.setUserCars(BMW);
//        userService.add(Zaur);
//        Dima.setUserCars(Lada);
//        userService.add(Dima);
//        Anna.setUserCars(Mers);
//        userService.add(Anna);

        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println("Car = " + user.getUserCars());
//            System.out.println();
//        }

        for (User user : userService.listUsers()) {
            System.out.println(user + " " + user.getUserCars());
        }

//        try {
//            System.out.println(userService.getUserByCar("Long", 7));
//        } catch (NoResultException e) {
//            System.out.println("Не существуют такого Юзера");
//        }

        context.close();
    }
}
