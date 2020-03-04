package web.service;
/*
 *
 *@Data 04.03.2020
 *@autor Fedorov Yuri
 *@project spring_mvc
 *
 */

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class ServiceCarImpl implements ServiceCar {
    private Object Long;

    @Override
    public List<Car> findSome() {
        return findThreeCar();
    }

    private List<Car> findThreeCar() {
        List<Car> cars=new ArrayList<>();
        String[] models={"BMV","Audi","Mers"};
        String[] colors={"black","White","Yellow"};
        for(int i=0;i<3;i++){
            cars.add(new Car().setModel(models[i]).setColor(colors[i]).setId(i));
        }
        return cars;
    }
}
