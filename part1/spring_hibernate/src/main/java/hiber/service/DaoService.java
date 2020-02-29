package hiber.service;
/*
 *
 *@Data 25.02.2020
 *@autor Fedorov Yuri
 *@project spring_hibernate
 *
 */

import hiber.model.User;

import java.util.List;

public interface DaoService <T> {
    void add(T model);
    List<T> findAll();

}
