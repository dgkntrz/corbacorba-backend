package com.corba.corbacorba.service;

import com.corba.corbacorba.converter.UserConverter;
import com.corba.corbacorba.dto.UserDto;
import com.corba.corbacorba.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserConverter userConverter;

    @Override
    public List<UserDto> list() {
        return userConverter.convertToDtoList(userRepo.findAll());
    }
}
