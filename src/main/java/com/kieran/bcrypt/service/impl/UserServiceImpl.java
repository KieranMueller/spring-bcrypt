package com.kieran.bcrypt.service.impl;

import com.kieran.bcrypt.entity.User;
import com.kieran.bcrypt.repository.UserRepository;
import com.kieran.bcrypt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    @Override
    public String login(User user) {
        Optional<User> user1 = userRepository.findById(user.getUsername());
        if (user1.isEmpty()) return "username not found";
        if(encoder.matches(user.getPassword(), user1.get().getPassword()))
            return "success!";
        return "unable to verify credentials";
    }
}
