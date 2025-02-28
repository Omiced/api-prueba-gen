package com.generation.prueba.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "lessons")
public class LessonsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String type;

    /* el otro lado de la relacion ya no necesita el join */
    @ManyToMany(mappedBy = "lessons")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<LearnersEntity> learners;

    public LessonsEntity() {
    }

    public LessonsEntity(Long id, String description, String type, List<LearnersEntity> learners) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.learners = learners;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<LearnersEntity> getLearners() {
        return learners;
    }

    public void setLearners(List<LearnersEntity> learners) {
        this.learners = learners;
    }
}
