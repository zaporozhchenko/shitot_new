package com.shitot.repository;

import com.shitot.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Next on 26.07.2016.
 */
@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User login(User user) {
        User result = em.createNamedQuery(User.GET_BY_LOGIN, User.class)
                        .setParameter("login", user.getLogin())
                        .setParameter("password", user.getPassword())
                        .getSingleResult();
        return result;
    }
}
