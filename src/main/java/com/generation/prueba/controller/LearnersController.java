package com.generation.prueba.controller;

import com.generation.prueba.dto.LearnersRequestDTO;
import com.generation.prueba.dto.LessonRequestDTO;
import com.generation.prueba.model.LearnersEntity;
import com.generation.prueba.model.LessonsEntity;
import com.generation.prueba.repository.LearnersRepository;
import com.generation.prueba.repository.LessonsRepository;
import com.generation.prueba.service.LearnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/learners" ) //http://localhost:8080
public class LearnersController {
    private final LearnersService learnersService;
    private final LessonsRepository lessonsRepository;
    @Autowired
    public LearnersController(LearnersService learnersService, LessonsRepository lessonsRepository){
        this.learnersService = learnersService;
        this.lessonsRepository = lessonsRepository;
    }

    @GetMapping //http://localhost:8080/api/learners
    public List<LearnersEntity> getAllLearners(@RequestParam(required = false) String name){
        if(name != null) return learnersService.getLearnerByname(name);
        return learnersService.getAllLearners();
    }

    @GetMapping(path = "{learnerId}")  //http://localhost:8080/api/learners/1
    public LearnersEntity getLearner(@PathVariable("learnerId") Long id) {
        return learnersService.getLearnerById(id);
    }



    @DeleteMapping(path = "{learnerId}")
    public LearnersEntity deleteLearner(@PathVariable("learnerId" ) Long id){
        return learnersService.deleteById(id);
    }

    @PostMapping
    public LearnersEntity addLearner(@RequestBody LearnersRequestDTO learnersRequestDTO){
        // Buscar los learners por sus IDs
        List<LessonsEntity> lessons = lessonsRepository.findAllById(learnersRequestDTO.getLessonsIds());

        // Crear la nueva lección y asignarle los learners encontrados
        LearnersEntity learner = new LearnersEntity();
        learner.setName(learnersRequestDTO.getName());
        learner.setEmail(learnersRequestDTO.getEmail());
        learner.setObservations((learnersRequestDTO.getObservations()));
        learner.setLessons(lessons);
        // Guardar en la BD
        return learnersService.addLearner(learner);

    }

    @PutMapping(path = "{learnerId}")
    public LearnersEntity updateLearner(
            @PathVariable("learnerId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String observations
                                        ){
        return learnersService.updateLearner(id, name, email, observations);
    }

}
