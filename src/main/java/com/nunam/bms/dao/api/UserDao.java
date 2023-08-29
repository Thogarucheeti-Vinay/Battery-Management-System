package com.nunam.bms.dao.api;

import com.nunam.bms.dao.entity.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> getUserDetailsById(long userId);
}
