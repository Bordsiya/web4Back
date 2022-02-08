package com.example.web4.converters;

import com.example.web4.dto.FullDotDTO;
import com.example.web4.entity.DotEntity;
import org.springframework.stereotype.Component;

@Component
public class DotConverter {

    public FullDotDTO fromEntityToDTO(DotEntity dotEntity){
        FullDotDTO fullDotDTO = new FullDotDTO();
        fullDotDTO.setX(dotEntity.getX());
        fullDotDTO.setY(dotEntity.getY());
        fullDotDTO.setR(dotEntity.getR());
        fullDotDTO.setHit(dotEntity.getIsHit());
        fullDotDTO.setTime(dotEntity.getTime());
        return fullDotDTO;
    }
}
