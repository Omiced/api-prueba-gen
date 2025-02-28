package com.generation.prueba.service;

import com.generation.prueba.model.LessonsEntity;
import com.generation.prueba.repository.LessonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonsService {
    private final LessonsRepository lessonsRepository;

    @Autowired
    public LessonsService(LessonsRepository lessonsRepository){
        this.lessonsRepository = lessonsRepository;
    }

    public LessonsEntity addLesson(LessonsEntity lesson){
        return lessonsRepository.save(lesson);
    }

    public List<LessonsEntity> getAllLessons(){
        return this.lessonsRepository.findAll();
    }

    public LessonsEntity getLessonById(Long id){
        return this.lessonsRepository.getByIdWithLearners(id).orElseThrow(
                () -> new IllegalArgumentException("La lección con id " + id + " no existe")
        );
    }

    public LessonsEntity updateLesson(Long id, String description, String type){
        LessonsEntity tmp = null;
        if(lessonsRepository.existsById(id))return tmp;
        tmp = lessonsRepository.findById(id).get();
        if(description != null)tmp.setDescription(description);
        if(type != null)tmp.setType(type);
        return tmp;
    }

    public LessonsEntity deleteById(Long id){
        LessonsEntity tmp = null;
        if(lessonsRepository.existsById(id))return tmp;
        tmp = lessonsRepository.findById(id).get();
        lessonsRepository.deleteById(id);
        return tmp;
    }
}
