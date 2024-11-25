package com.example.eldorado.security.service;

import com.example.eldorado.entity.ERole;
import com.example.eldorado.entity.Role;
import com.example.eldorado.entity.User;
import com.example.eldorado.repository.RoleRepository;
import com.example.eldorado.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final RoleRepository roleRepository;
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Username not found"));

        return UserDetailsImp.build(user);
    }

    //Register

    public ResponseEntity<String> singUp(Map<String, String> requestMap) {
        return null;
    }

    private User getUserFromMap(Map<String, String> requestMap) {

        User user = new User();
        Role roleUser = roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Error: Role not found"));

        Set<Role> roles = new HashSet<>();
        roles.add(roleUser);

        user.setUsername(requestMap.get("username"));
        user.setPassword(requestMap.get("password"));
        user.setEmail(requestMap.get("email"));
        user.setRoles(roles);

        return user;
    }
}
