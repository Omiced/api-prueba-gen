package com.generation.prueba.controller;

import com.generation.prueba.model.LessonsEntity;
import com.generation.prueba.service.LessonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/lessons")//http://localhost:8080
public class LessonsController {
    private final LessonsService lessonsService;
    @Autowired
    public LessonsController(LessonsService lessonsService){
        this.lessonsService = lessonsService;
    }

    @GetMapping //http://localhost:8080/api/lessons
    public List<LessonsEntity> getAllLessons(){
        return this.lessonsService.getAllLessons();
    }

    @GetMapping(path = "{lessonId}")
    public LessonsEntity getLessonById(@PathVariable("lessonId") Long id){
        return this.lessonsService.getLessonById(id);
    }

}
