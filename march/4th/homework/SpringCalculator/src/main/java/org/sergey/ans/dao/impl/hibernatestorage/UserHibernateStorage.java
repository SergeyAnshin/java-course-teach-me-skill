package org.sergey.ans.dao.impl.hibernatestorage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.sergey.ans.dao.UserDAO;
import org.sergey.ans.entity.CalculationResult;
import org.sergey.ans.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository(value = "userHibernateStorage")
@Transactional
public class UserHibernateStorage implements UserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public UserHibernateStorage(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean exists(User user) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", user.getEmail());
        List<User> users = query.getResultList();
        session.close();
        return !users.isEmpty();
    }

    @Override
    public boolean save(User user) {
        Session session = sessionFactory.openSession();
        Serializable resultId = session.save(user);
        session.close();
        return resultId != null;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("SELECT u FROM User u", User.class);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        User foundUser = query.uniqueResult();
        Set<CalculationResult> calculationResultList = foundUser.getCalculationResultList();
        session.close();
        return Optional.of(foundUser);
    }
}
