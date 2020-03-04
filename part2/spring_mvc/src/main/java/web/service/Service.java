package web.service;

import java.util.List;

/*
 *
 *@Data 04.03.2020
 *@autor Fedorov Yuri
 *@project spring_mvc
 *
 */
public interface Service<T> {
    List<T> findSome();
}
