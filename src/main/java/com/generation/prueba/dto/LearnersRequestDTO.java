package com.generation.prueba.dto;

import com.generation.prueba.model.LessonsEntity;

import java.util.List;

public class LearnersRequestDTO {
    private String name;
    private String email;
    private String observations;
    private List<Long> lessonsIds;

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

    public List<Long> getLessonsIds() {
        return lessonsIds;
    }

    public void setLessonsIds(List<Long> lessonsIds) {
        this.lessonsIds = lessonsIds;
    }
}
