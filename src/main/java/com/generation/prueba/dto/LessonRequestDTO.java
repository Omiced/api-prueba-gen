package com.generation.prueba.dto;

import java.util.List;

public class LessonRequestDTO {
        private String type;
        private String description;
        private List<Long> learnerIds;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getLearnerIds() {
        return learnerIds;
    }

    public void setLearnerIds(List<Long> learnerIds) {
        this.learnerIds = learnerIds;
    }
}
