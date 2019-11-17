package com.game.housie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.housie.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
