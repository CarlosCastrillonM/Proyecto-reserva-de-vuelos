package com.example.eldorado.security.service;

import com.example.eldorado.entity.User;
import com.example.eldorado.repository.UserRepository;
import com.example.eldorado.security.service.UserDetailsImp;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImp implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Username not found"));

        return UserDetailsImp.build(user);
    }
}
