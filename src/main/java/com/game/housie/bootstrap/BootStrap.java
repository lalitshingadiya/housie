package com.game.housie.bootstrap;

import com.game.housie.dao.RoleRepository;
import com.game.housie.entity.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {

    RoleRepository roleRepository;

    public BootStrap(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(roleRepository.count() == 0){
            //roleRepository.save(Role.builder().name("ADMIN").build());
            roleRepository.save(Role.builder().name("USER").build());
        }
    }
}
