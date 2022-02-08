package com.example.web4.service;

import com.example.web4.converters.DotConverter;
import com.example.web4.dto.FullDotDTO;
import com.example.web4.entity.DotEntity;
import com.example.web4.entity.UserEntity;
import com.example.web4.repos.DotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DotService {
    private final DotRepo dotRepo;
    private final DotConverter dotConverter;

    @Autowired
    public DotService(DotRepo dotRepo, DotConverter dotConverter){
        this.dotRepo = dotRepo;
        this.dotConverter = dotConverter;
    }

    public DotEntity createDot(DotEntity dotEntity) {
        return dotRepo.save(dotEntity);
    }

    public List<DotEntity> getDotsByUser(UserEntity user) {
        return dotRepo.getDotsByUser(user);
    }

    public void deleteDotsByUser(UserEntity user){
        dotRepo.deleteDotsByUser(user);
    }

    public List<FullDotDTO> getFullDotsByUser(UserEntity userEntity){
        return getDotsByUser(userEntity)
                .stream()
                .map(dotConverter::fromEntityToDTO)
                .collect(Collectors.toList());
    }

    public FullDotDTO createFullDot(DotEntity dotEntity){
        return dotConverter.fromEntityToDTO(createDot(dotEntity));
    }

}
