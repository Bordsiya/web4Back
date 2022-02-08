package com.example.web4.controllers;


import com.example.web4.dto.DefaultResponse;
import com.example.web4.dto.TokenDTO;
import com.example.web4.dto.UserDTO;
import com.example.web4.entity.UserEntity;
import com.example.web4.exceptions.UserAlreadyExistException;
import com.example.web4.exceptions.UserNotFoundException;
import com.example.web4.exceptions.WrongPasswordException;
import com.example.web4.security.JwtTokenProvider;
import com.example.web4.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping ("/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserController(UserService userService,
                          PasswordEncoder passwordEncoder,
                          JwtTokenProvider jwtTokenProvider){
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Operation(summary = "Метод для регистрации пользователя")
    @PostMapping (value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DefaultResponse createUser(@RequestBody @Valid UserDTO userDTO) throws UserAlreadyExistException {
            if (userService.findByLogin(userDTO.getLogin()) != null) throw new UserAlreadyExistException("Пользователь с данным логином уже существует: " + userDTO.getLogin());

            userService.addUser(new UserEntity(
                    userDTO.getLogin(),
                    passwordEncoder.encode(userDTO.getPassword())
            ));
            return new DefaultResponse("Пользователь " + userDTO.getLogin() + " успешно создан");

    }

    @Operation(summary = "Метод для авторизации пользователя")
    @PostMapping (value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TokenDTO loginUser(@RequestBody @Valid UserDTO userDTO) throws UserNotFoundException, WrongPasswordException {
        UserEntity userFromDB = userService.findByLogin(userDTO.getLogin());
        if (userFromDB == null) throw new UserNotFoundException("Пользователь с таким логином не найден в бд: " + userDTO.getLogin());
        else if (!passwordEncoder.matches(userDTO.getPassword(), userFromDB.getPassword())) throw new WrongPasswordException("Введен неправильный пароль");
        else {
            String token = jwtTokenProvider.createToken(userDTO.getLogin());
            return new TokenDTO(token);
        }
    }
}
