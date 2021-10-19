package com.corba.corbacorba.repository;

import com.corba.corbacorba.entitiy.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<UserEntity,Integer> {
    List<UserEntity> findAll();
    UserEntity findByUsernameAndPassword(String username, String password);

}
