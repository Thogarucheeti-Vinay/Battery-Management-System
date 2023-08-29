package com.nunam.bms.dao.impl;

import com.nunam.bms.dao.api.UserDao;
import com.nunam.bms.dao.entity.User;
import com.nunam.bms.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUserDetailsById(long userId) {
        LOGGER.info("In UserdaoImpl::getUserById::{}", userId);
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty())
            throw new RuntimeException("User not found!");
        return user;
    }
}
