package org.sergey.ans.dao.impl.jpastorage;

import org.sergey.ans.dao.UserDAO;
import org.sergey.ans.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository(value = "jpaUserDAO")
@Transactional
public class JpaUserDAO implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean exists(User user) {
        TypedQuery<Long> namedQuery = entityManager.createNamedQuery("User.exists", Long.class);
        namedQuery.setParameter("email", user.getEmail());
        boolean exists = namedQuery.getSingleResult() > 0;
        entityManager.close();
        return exists;
    }

    @Override
    public boolean save(User user) {
        entityManager.persist(user);
        boolean isSaved = entityManager.contains(user);
        entityManager.close();
        return isSaved;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> namedQuery = entityManager.createNamedQuery("User.findAll", User.class);
        List<User> users = namedQuery.getResultList();
        entityManager.close();
        return users;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        TypedQuery<User> namedQuery = entityManager.createNamedQuery("User.findByEmail", User.class);
        namedQuery.setParameter("email", email);
        Optional<User> user = namedQuery.getResultStream().findFirst();
        entityManager.close();
        return user;
    }
}
