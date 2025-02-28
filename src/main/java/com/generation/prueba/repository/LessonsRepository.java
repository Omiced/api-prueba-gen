package com.generation.prueba.repository;

import com.generation.prueba.model.LessonsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonsRepository extends JpaRepository<LessonsEntity,Long> {
    @Query("SELECT l FROM LessonsEntity l JOIN FETCH l.learners WHERE l.id = :id")
    Optional<LessonsEntity> getByIdWithLearners(@Param("id") Long id);
    @Query("SELECT l FROM LessonsEntity l JOIN FETCH l.learners")
    List<LessonsEntity> getAllWithLearners();

}
