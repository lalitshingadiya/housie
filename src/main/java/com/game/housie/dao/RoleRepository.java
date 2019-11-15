package com.game.housie.dao;

import com.game.housie.model.Role;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
 public List<Role> findAll();
 //public Role findNameById();
 Optional<Role> findById(Long id);
}
