package org.sergey.ans.dao;

import org.sergey.ans.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class JpaUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public JpaUserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(User user) {
         entityManager.persist(user);
         entityManager.close();
    }

    public User findById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.close();
        return user;
    }

    public void remove(User user) {
        entityManager.remove(user);
        entityManager.close();
    }

    public List<User> findAllByName(String name) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findAllByName", User.class);
        query.setParameter("name", name);
        List<User> users = query.getResultList();
        entityManager.close();
        return users;
    }
}
