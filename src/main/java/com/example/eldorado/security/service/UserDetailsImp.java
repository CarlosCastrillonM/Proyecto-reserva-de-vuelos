package com.example.eldorado.service;

import com.example.eldorado.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;
import java.util.List;

public class UserDetailsImp implements UserDetails {
    private Integer id;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImp(Integer id, String username, String email, String password);

    public static UserDetailsImp build(User user) {
        List<GrantedAuthority> authorities = user
    }
}
