package com.corba.corbacorba.service;

import com.corba.corbacorba.converter.UserConverter;
import com.corba.corbacorba.dto.UserDto;
import com.corba.corbacorba.entitiy.UserEntity;
import com.corba.corbacorba.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthServiceImp implements AuthService{
    @Autowired
    private UserRepo userRepository;

    @Autowired
    private UserConverter userConverter;

    public UserDto login(String username, String password) {
        UserEntity user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            return null;
        } else {
            // authentication rolleri ayarlanıyor
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

            user.getRoleList().forEach(r -> grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));

            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(
                            user,
                            password,
                            grantedAuthorities));

            return userConverter.convertToDto(user);
        }
    }

    @Override
    public UserDto register(UserDto request) {
        try{
            UserEntity userEntity = userRepository.save(userConverter.convertToEntity(request));
            return userConverter.convertToDto(userEntity);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }


    }
}
