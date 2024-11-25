package com.example.eldorado.security.service;

import com.example.eldorado.dto.UserInfoDto;
import com.example.eldorado.entity.ERole;
import com.example.eldorado.entity.Role;
import com.example.eldorado.entity.User;
import com.example.eldorado.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("[ERROR]: is Empty");
        }
        return UserDetailsImp.build(userOptional.get());
    }

    public UserInfoDto addUser(UserInfoDto userInfo) {
        User user = new User(null, userInfo.name(), userInfo.email(), passwordEncoder.encode(userInfo.password()),
                Arrays.stream(userInfo.roles().split(" "))
                        .map(role -> new Role(ERole.valueOf(role)))
                        .collect(Collectors.toSet())
        );
        user = userRepository.save(user);
        return new UserInfoDto(user.getUsername(), user.getEmail(), userInfo.password(), userInfo.roles());
    }
}
