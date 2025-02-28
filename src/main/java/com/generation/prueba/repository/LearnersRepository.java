package com.generation.prueba.repository;

import com.generation.prueba.model.LearnersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LearnersRepository extends JpaRepository<LearnersEntity,Long> {
    @Query("SELECT l FROM LearnersEntity l LEFT JOIN FETCH l.lessonsEntity WHERE l.id = :learnerId")
    Optional<LearnersEntity> findByIdWithLessons(@Param("learnerId") Long learnerId);
    @Query("SELECT l From LearnersEntity l LEFT JOIN FETCH l.lessonsEntity")
    List<LearnersEntity> getAllWithLessons();
}
