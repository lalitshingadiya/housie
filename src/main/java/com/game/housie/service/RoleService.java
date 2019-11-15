package com.game.housie.service;

import com.game.housie.model.Role;
import com.game.housie.model.User;

import java.util.Set;

public interface RoleService {

    void save(Role role);

    Role findByRole(String rolename);

    Set<Role> findRoles();
}
