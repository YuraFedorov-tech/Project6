package web.service;
/*
 *
 *@Data 25.02.2020
 *@autor Fedorov Yuri
 *@project spring_hibernate
 *
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;



    @Transactional
    @Override
    public void add(Car model) {

        carDao.add(model);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Car findById(Long id) {
        return carDao.findById(id);
    }

   // @Transactional
    @Override
    public void update(Car model) {
        carDao.update(model);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        carDao.delete(id);
    }

    @Transactional
    @Override
    public void drop() {
        carDao.drop();
    }

    @Transactional
    @Override
    public void create() {
        carDao.create();
    }
}
