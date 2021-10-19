package com.corba.corbacorba.repository;

import com.corba.corbacorba.entitiy.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepo extends CrudRepository<RoleEntity, Integer> {
    List<RoleEntity> findAll();
}
