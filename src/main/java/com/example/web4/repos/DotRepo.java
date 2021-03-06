package com.example.web4.repos;

import com.example.web4.entity.DotEntity;
import com.example.web4.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DotRepo extends CrudRepository<DotEntity, Long> {
    List<DotEntity> getDotsByUser(UserEntity user);
    @Transactional
    void deleteDotsByUser(UserEntity userEntity);
}
