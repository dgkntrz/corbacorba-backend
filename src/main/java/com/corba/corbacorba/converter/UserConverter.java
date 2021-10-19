package com.corba.corbacorba.converter;

import com.corba.corbacorba.core.AbstractBaseConverter;
import com.corba.corbacorba.dto.UserDto;
import com.corba.corbacorba.entitiy.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractBaseConverter<UserDto, UserEntity> {
}
