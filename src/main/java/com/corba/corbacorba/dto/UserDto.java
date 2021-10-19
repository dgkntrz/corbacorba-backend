package com.corba.corbacorba.dto;

import com.corba.corbacorba.core.BaseDto;

import java.util.Date;
import java.util.List;

public class UserDto extends BaseDto {

    private String email;
    private String username;
    private String password;
    private List<RoleDto> roleList;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<RoleDto> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleDto> roleList) {
        this.roleList = roleList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
