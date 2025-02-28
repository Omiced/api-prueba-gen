package com.generation.prueba.repository;

import com.generation.prueba.model.LessonsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LessonsRepository extends JpaRepository<LessonsEntity,Long> {
    @Query("SELECT l FROM LessonsEntity l LEFT JOIN FETCH l.learnersEntity WHERE l.id = :lessonId")
    Optional<LessonsEntity> getByIdWithLearners(@Param("lessonId") Long lessonId);

    @Query("SELECT l FROM LessonsEntity l LEFT JOIN FETCH l.learnersEntity")
    List<LessonsEntity> getAllWithLearners();

}
