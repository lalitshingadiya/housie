package com.game.housie.service;

import com.game.housie.dao.RoleRepository;
import com.game.housie.dao.UserRepository;
import com.game.housie.entity.Role;
import com.game.housie.entity.User;

import com.game.housie.model.MediUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService,UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    
    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        MediUser mediUser = null;

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Role r=roleRepository.findById(Long.parseLong(user.getRoles())).orElse(null);
        System.out.println("--"+r.getName()+"---");


    	grantedAuthorities.add(new SimpleGrantedAuthority(r.getName()));
    if(user!=null) {
        mediUser = new MediUser(username,   user.getPassword(), user.getId(),grantedAuthorities);
    }else{
        mediUser = new MediUser(username,   "NA", (long) 0,null);
    }
        
       // return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        return mediUser;
    }
    
}
