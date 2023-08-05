package com.kieran.bcrypt.repository;

import com.kieran.bcrypt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
