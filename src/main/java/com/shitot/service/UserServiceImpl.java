package com.shitot.service;

import com.shitot.model.User;
import com.shitot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Next on 26.07.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User login(User user) {
        User result = null;
        try {
            result = repository.login(user);
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public User register(User user) {
        User result = null;
        try {
            result = repository.register(user);
        } catch (Exception e) {
        }
        return result;
    }
}
