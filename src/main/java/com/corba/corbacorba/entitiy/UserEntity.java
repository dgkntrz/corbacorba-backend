package com.corba.corbacorba.entitiy;

import com.corba.corbacorba.core.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mt_user")
public class UserEntity extends BaseEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "mt_user_role",
            joinColumns = {
                    @JoinColumn(name = "fk_user_id",
                            nullable = false,
                            updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "fk_role_id",
                            nullable = false,
                            updatable = false)}

    )
    private List<RoleEntity> roleList;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleEntity> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleEntity> roleList) {
        this.roleList = roleList;
    }
}
