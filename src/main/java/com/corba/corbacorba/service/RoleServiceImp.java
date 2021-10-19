package com.corba.corbacorba.service;

import com.corba.corbacorba.converter.RoleConverter;
import com.corba.corbacorba.dto.RoleDto;
import com.corba.corbacorba.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private RoleConverter roleConverter;

    @Override
    public List<RoleDto> list() {
        return roleConverter.convertToDtoList(roleRepo.findAll());
    }
}
