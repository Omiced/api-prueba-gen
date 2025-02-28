package com.generation.prueba.service;

import com.generation.prueba.model.LearnersEntity;
import com.generation.prueba.model.LessonsEntity;
import com.generation.prueba.repository.LearnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnersService {
    private final LearnersRepository learnersRepository;
    @Autowired
    public LearnersService(LearnersRepository learnersRepository){
        this.learnersRepository = learnersRepository;
    }

    public LearnersEntity addLearner(LearnersEntity learner){
        return this.learnersRepository.save(learner);
    }

    public List<LearnersEntity> getAllLearners(){
        return this.learnersRepository.findAll();
    }

    public LearnersEntity getLearnerById(Long id){
        return this.learnersRepository.findByIdWithLessons(id).orElseThrow(
        () -> new IllegalArgumentException("El learner con id " + id + " no existe"));
    }

    public LearnersEntity updateLearner(Long id, String name, String email, String observations){
        LearnersEntity tmp = null;
        if(learnersRepository.existsById(id))return tmp;
        tmp = learnersRepository.findById(id).get();
        if(name != null)tmp.setName(name);
        if(email != null)tmp.setEmail(email);
        if(observations != null)tmp.setObservations(observations);
        return tmp;
    }

    public LearnersEntity deleteById(Long id){
        LearnersEntity tmp = null;
        if(learnersRepository.existsById(id))return tmp;
        tmp = learnersRepository.findById(id).get();
        learnersRepository.deleteById(id);
        return tmp;
    }
}
