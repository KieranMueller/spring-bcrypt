package com.kieran.bcrypt;

import com.kieran.bcrypt.entity.User;
import com.kieran.bcrypt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Seeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        userRepository.saveAndFlush(new User("kieran", encoder.encode("test")));
    }
}
