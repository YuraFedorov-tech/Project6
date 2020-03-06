package web.service;
/*
 *
 *@Data 25.02.2020
 *@autor Fedorov Yuri
 *@project spring_hibernate
 *
 */

import java.util.List;

public interface DaoService <T> {
    void add(T model);
    List<T> findAll();
    T findById(Long id);
    void delete(Long id);
    void drop();
    void create();
    void update (T model);
}
