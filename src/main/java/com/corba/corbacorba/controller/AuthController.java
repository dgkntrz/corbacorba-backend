package com.corba.corbacorba.controller;

import com.corba.corbacorba.dto.ErrorDto;
import com.corba.corbacorba.dto.RoleDto;
import com.corba.corbacorba.dto.UserDto;
import com.corba.corbacorba.service.AuthService;
import com.corba.corbacorba.service.RoleService;
import com.corba.corbacorba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RoleService roleService;

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public ResponseEntity<List<UserDto>> list() {
//        return new ResponseEntity<>(userService.list(), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/listrole", method = RequestMethod.GET)
//    public ResponseEntity<List<RoleDto>> listRole() {
//        return new ResponseEntity<>(roleService.list(), HttpStatus.OK);
//    }

    @Autowired
    private AuthService authenticationService;


    @CrossOrigin(origins = {"http://localhost:3000", "http://139.162.161.225"}, allowCredentials = "true")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<UserDto> login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        UserDto userDto = authenticationService.login(username, password);
        if (userDto == null) {
            userDto = new UserDto();
            userDto.setErrorDto(new ErrorDto(105, "Kullanıcı adı veya şifre hatalı."));
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } else {
            UserDto userDtoBasicResponse = new UserDto();
            userDtoBasicResponse.setPkid(userDto.getPkid());
            userDtoBasicResponse.setEmail(userDto.getEmail());
            userDtoBasicResponse.setUsername(userDto.getUsername());
            userDtoBasicResponse.setRoleList(userDto.getRoleList());
            return new ResponseEntity<>(userDtoBasicResponse, HttpStatus.OK);

        }
    }

    @CrossOrigin(origins = {"http://localhost:3000", "http://139.162.161.225"}, allowCredentials = "true")
//    @Secured({RoleConstants.ROLE_ADMIN})
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserDto add(@RequestBody UserDto request) {
        UserDto userDto = authenticationService.register(request);
        if (userDto == null) {
            userDto = new UserDto();
            userDto.setErrorDto(new ErrorDto(106, "Kullanıcı Adı veya email kayıtlı"));
        }
        return userDto;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity<UserDto> logOut() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
