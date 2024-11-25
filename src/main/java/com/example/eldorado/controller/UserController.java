package com.example.eldorado.controller;

import com.example.eldorado.dto.AuthRequestDto;
import com.example.eldorado.dto.UserInfoDto;
import com.example.eldorado.security.jwt.JwtUtil;
import com.example.eldorado.security.service.UserDetailsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserDetailsServiceImpl service;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    UserController(UserDetailsServiceImpl service, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.service = service;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserInfoDto> addNewUser(@RequestBody UserInfoDto userInfo) {
        UserInfoDto response = service.addUser(userInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateAndGetToken(@RequestBody AuthRequestDto authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.email(), authRequest.password()));

        if (authentication.isAuthenticated()) {
            String token = jwtUtil.generateJwtToken(authentication);
            return ResponseEntity.ok(token);

        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}
