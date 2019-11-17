package com.game.housie.service;

import com.game.housie.entity.Role;

import java.util.Set;

public interface RoleService {

    void save(Role role);

    Role findByRole(String rolename);

    Set<Role> findRoles();
}
