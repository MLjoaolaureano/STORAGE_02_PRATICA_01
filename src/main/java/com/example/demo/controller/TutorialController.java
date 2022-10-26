package com.example.demo.controller;

import com.example.demo.model.Tutorial;
import com.example.demo.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tutorials/")
public class TutorialController {

    @Autowired
    TutorialService tutorialService;


    @PostMapping
    ResponseEntity<Tutorial> create(@RequestBody Tutorial tutorial) {
        Tutorial tutorialResponse = tutorialService.create(tutorial);

        return (new ResponseEntity(tutorialResponse, HttpStatus.CREATED));
    }

    @GetMapping
    ResponseEntity<List<Tutorial>> list() {
        List<Tutorial> tutorialListResponse = tutorialService.listAll();

        return (new ResponseEntity(tutorialListResponse, HttpStatus.FOUND));
    }

    @GetMapping("/{id}")
    ResponseEntity<List<Tutorial>> getById(@PathVariable("id") Long idTutorial) {
        Tutorial tutorialResponse = tutorialService.findById(idTutorial);

        return (new ResponseEntity(tutorialResponse, HttpStatus.FOUND));
    }

    @PutMapping("/{id}")
    ResponseEntity<Tutorial> update(@PathVariable("id") int idTutorial, @RequestBody Tutorial tutorial) {
        Tutorial tutorialUpdatedResponse = tutorialService.update(idTutorial, tutorial);

        return (new ResponseEntity(tutorialUpdatedResponse, HttpStatus.OK));
    }

    @DeleteMapping
    ResponseEntity<Boolean> remove() {
        Boolean deleteResponse = tutorialService.remove();

        return (new ResponseEntity(null, HttpStatus.NO_CONTENT));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> remove(@PathVariable("id") long idTestCase) {
        Boolean deleteResponse = tutorialService.remove(idTestCase);

        return (new ResponseEntity(null, HttpStatus.NO_CONTENT));
    }

    @GetMapping("/testing")
    ResponseEntity<List<Tutorial>> getByLastUpdated(@RequestParam(name = "title", required = true) String textToContains) {
        List<Tutorial> tutorialListResponse = tutorialService.getTutorialWhereTitleContains(textToContains);

        return (new ResponseEntity(tutorialListResponse, HttpStatus.FOUND));
    }

    @GetMapping("/published")
    ResponseEntity<List<Tutorial>> getBySituation(@RequestParam(name = "situation", required = true) String situation) {
        List<Tutorial> tutorialListResponse = tutorialService.getTutorialBySituation(situation);

        return (new ResponseEntity(tutorialListResponse, HttpStatus.FOUND));
    }
}
