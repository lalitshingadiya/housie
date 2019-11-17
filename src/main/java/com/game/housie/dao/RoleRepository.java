package com.game.housie.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.housie.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
 public List<Role> findAll();
 Optional<Role> findById(Long id);
}
