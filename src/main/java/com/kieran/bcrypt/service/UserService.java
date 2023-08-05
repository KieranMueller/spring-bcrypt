package com.kieran.bcrypt.service;

import com.kieran.bcrypt.entity.User;
import java.util.List;

public interface UserService {

    List<User> getAll();

    User createUser(User user);

    String login(User user);
}
