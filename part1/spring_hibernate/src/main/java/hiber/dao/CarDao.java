package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

/*
 *
 *@Data 24.02.2020
 *@autor Fedorov Yuri
 *@project spring_hibernate
 *
 */
public interface CarDao extends Dao<Car> {
    User findUserByNameAndSeries(Car car);
}
