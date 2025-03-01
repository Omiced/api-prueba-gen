package com.generation.prueba.controller;

import com.generation.prueba.dto.LessonRequestDTO;
import com.generation.prueba.model.LearnersEntity;
import com.generation.prueba.model.LessonsEntity;
import com.generation.prueba.repository.LearnersRepository;
import com.generation.prueba.service.LessonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/lessons")//http://localhost:8080
public class LessonsController {
    private final LessonsService lessonsService;
    private final LearnersRepository learnersRepository;
    @Autowired
    public LessonsController(LessonsService lessonsService, LearnersRepository learnersRepository){
        this.lessonsService = lessonsService;
        this.learnersRepository = learnersRepository;
    }

    @GetMapping //http://localhost:8080/api/lessons
    public List<LessonsEntity> getAllLessons(@RequestParam(required = false) String description){
        if(description != null) return this.lessonsService.getLessonByDescription(description);
        return this.lessonsService.getAllLessons();
    }

    @GetMapping(path = "{lessonId}")
    public LessonsEntity getLessonById(@PathVariable("lessonId") Long id){
        return this.lessonsService.getLessonById(id);
    }

    @PostMapping
    public LessonsEntity addLesson(@RequestBody LessonRequestDTO lessonRequest){
        // Buscar los learners por sus IDs
        List<LearnersEntity> learners = learnersRepository.findAllById(lessonRequest.getLearnerIds());

        // Crear la nueva lección y asignarle los learners encontrados
        LessonsEntity lesson = new LessonsEntity();
        lesson.setType(lessonRequest.getType());
        lesson.setDescription(lessonRequest.getDescription());
        lesson.setLearners(learners);

        // Guardar en la BD
        return lessonsService.addLesson(lesson);

    }
}
