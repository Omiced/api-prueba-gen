package com.generation.prueba.controller;

import com.generation.prueba.model.LearnersEntity;
import com.generation.prueba.repository.LearnersRepository;
import com.generation.prueba.service.LearnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/learners" ) //http://localhost:8080
public class LearnersController {
    private final LearnersService learnersService;
    @Autowired
    public LearnersController(LearnersService learnersService){
        this.learnersService = learnersService;
    }

    @GetMapping //http://localhost:8080/api/learners
    public List<LearnersEntity> getAllLearners(){
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
    public LearnersEntity updateLearner(@RequestBody LearnersEntity learner){
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
