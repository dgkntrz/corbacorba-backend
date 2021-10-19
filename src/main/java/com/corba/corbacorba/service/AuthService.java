package com.corba.corbacorba.service;

import com.corba.corbacorba.dto.UserDto;

public interface AuthService {
    UserDto login(String email, String password);

    UserDto register(UserDto request);
}
