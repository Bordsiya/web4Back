package com.example.web4.controllers;

import com.example.web4.dto.DotDTO;
import com.example.web4.dto.FullDotDTO;
import com.example.web4.dto.DefaultResponse;
import com.example.web4.entity.DotEntity;
import com.example.web4.entity.UserEntity;
import com.example.web4.service.DotService;
import com.example.web4.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping (value = "/dots")
public class DotController {
    private final UserService userService;
    private final DotService dotService;

    @Autowired
    public DotController(UserService userService, DotService dotService){
        this.dotService = dotService;
        this.userService = userService;
    }

    @Operation(summary = "Метод для получения всех точек пользователя")
    @GetMapping (value = "/getDots", produces = MediaType.APPLICATION_JSON_VALUE)
    List<FullDotDTO> getUserDots(){
        UserEntity userEntity = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        return dotService.getFullDotsByUser(userEntity);
    }

    @Operation(summary = "Метод для добавления точек")
    @PostMapping (value = "/addDots", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FullDotDTO addDots (@RequestBody @Valid DotDTO dotDTO){
        UserEntity userEntity = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        return dotService.createFullDot(new DotEntity(
                    dotDTO.getX(),
                    dotDTO.getY(),
                    dotDTO.getR(),
                    userEntity
        ));
    }

    @Operation(summary = "Метод для удаления точек")
    @DeleteMapping (value = "/deleteDots", produces = MediaType.APPLICATION_JSON_VALUE)
    DefaultResponse deleteUserDots(){
        UserEntity userEntity = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        dotService.deleteDotsByUser(userEntity);
        return new DefaultResponse("Точки пользователя успешно удалены");
    }
}
