package hiber.service;

import hiber.model.Car;
import hiber.model.User;

/*
 *
 *@Data 25.02.2020
 *@autor Fedorov Yuri
 *@project spring_hibernate
 *
 */
public interface CarService extends DaoService<Car> {
    User findUserByNameAndSeries(Car car);

}
