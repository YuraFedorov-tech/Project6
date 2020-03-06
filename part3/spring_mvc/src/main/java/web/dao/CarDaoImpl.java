package web.dao;
/*
 *
 *@Data 24.02.2020
 *@autor Fedorov Yuri
 *@project spring_hibernate
 *
 */


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void add(Car model) {
        sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public Car findById(Long id) {
        Session session = sessionFactory.openSession();
        Car car = session.get(Car.class, id);
        return car;
    }

    @Override
    public void update(Car model) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
    }

    @Override
    public List<Car> findAll() {
        TypedQuery<Car> query1 = sessionFactory.getCurrentSession().createQuery("from Car");
        return query1.getResultList();
    }

    @Override
    public void drop() {
////DROP TABLE IF EXISTS Car CASCADE CONSTRAINTS
//
        //   Session session=sessionFactory.getCurrentSession();
        //     session.createQuery("DROP TABLE car CASCADE").executeUpdate();
//        int y=sessionFactory.getCurrentSession().createQuery("DROP TABLE car cascade").executeUpdate();
    }

    @Override
    public void create() {

    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        String hql = "DELETE Car WHERE id = :id";
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            int rows = query.executeUpdate();
            transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
