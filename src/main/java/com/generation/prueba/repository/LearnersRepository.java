package com.generation.prueba.repository;

import com.generation.prueba.model.LearnersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LearnersRepository extends JpaRepository<LearnersEntity,Long> {
    @Query("SELECT l FROM LearnersEntity l JOIN FETCH l.lessons WHERE l.id = :id")
    Optional<LearnersEntity> findByIdWithLessons(@Param("id") Long id);
    @Query("SELECT l FROM LearnersEntity l JOIN FETCH l.lessons")
    List<LearnersEntity> getAllWithLessons();

}
