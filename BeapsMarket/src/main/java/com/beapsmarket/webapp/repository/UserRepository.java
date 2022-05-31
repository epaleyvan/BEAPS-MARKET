package com.beapsmarket.webapp.repository;

import com.beapsmarket.webapp.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUsersByEmail(String string);
    User findUsersByUsername(String string);
    boolean existsByEmail(String string);
}