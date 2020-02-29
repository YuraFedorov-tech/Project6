package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.DaoService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);
        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> users = userService.findAll();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
            Car car2 = new Car().setName("BMV" + Integer.toString(i)).setSeries(i).setOwner(user);
            carService.add(car2);
            user.setOwner(car2);
            userService.update(user);
        }


        List<Car> cars = carService.findAll();
        for (Car car : cars) {
            System.out.println("Id = " + car.getId());
            System.out.println("Name = " + car.getName());
            System.out.println("Series = " + car.getSeries());
            System.out.println("Owner_ID = " + car.getOwner().getId());
            System.out.println("Owner_ID = " + car.getOwner());
            System.out.println();
        }
        String name = "BMV3";
        int series = 3;
        Car car1 = new Car().setName(name).setSeries(series);
        User user = carService.findUserByNameAndSeries(car1);
        System.out.println(user + " at  name and series");
        context.close();
    }
}
