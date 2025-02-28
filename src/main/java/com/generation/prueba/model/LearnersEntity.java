package com.generation.prueba.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name="learners")
public class LearnersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,  unique = true)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = true)
    private String observations;


    /*creando una relacion y como queda muchos a muchos haciendo una
    tabla intermedia generada por JPA*/
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "learners_lessons",
            joinColumns = @JoinColumn(name="learner_id"),
            inverseJoinColumns = @JoinColumn(name="lesson_id")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<LessonsEntity> lessons;

    public LearnersEntity() {
    }

    public LearnersEntity(Long id, String name, String email, String observations, List<LessonsEntity> lessons) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.observations = observations;
        this.lessons = lessons;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public List<LessonsEntity> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonsEntity> lessons) {
        this.lessons = lessons;
    }
}
