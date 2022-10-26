package com.example.demo.service;

import com.example.demo.model.Tutorial;
import com.example.demo.repository.ITutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TutorialService {

    @Autowired
    ITutorialRepository tutorialRepository;


    public Tutorial create(Tutorial tutorial) {
        Tutorial newTutorial = tutorialRepository.save(tutorial);

        return newTutorial;
    }

    public List<Tutorial> listAll() {
        List<Tutorial> tutorials = new ArrayList<>();
        tutorialRepository.findAll().forEach(tutorials::add);
        return tutorials;
    }

    public List<Tutorial> getTutorialWhereTitleContains(String textToContains) {
        List<Tutorial> tutorials = new ArrayList<>();
        tutorialRepository.findByTitleIgnoreCaseContaining(textToContains).forEach(tutorials::add);
        return tutorials;
    }

    public Tutorial findById(long idTutorial) {
        Tutorial tutorial = tutorialRepository.findById(idTutorial).orElse(null);
        return tutorial;
    }

    public List<Tutorial> getTutorialBySituation(String situation) {
        List<Tutorial> tutorials = new ArrayList<>();
        tutorialRepository.findTutorialBySituation(situation).forEach(tutorials::add);
        return tutorials;
    }

    public Boolean remove() {
        tutorialRepository.deleteAll();
        return true;
    }

    public Boolean remove(Long idTutorial) {
        tutorialRepository.deleteById(idTutorial);
        return true;
    }

    public Tutorial update(long idTutorial, Tutorial newTutorial) {
        newTutorial.setId(idTutorial);
        Tutorial updatedTutorial = tutorialRepository.save(newTutorial);

        return updatedTutorial;
    }
}
