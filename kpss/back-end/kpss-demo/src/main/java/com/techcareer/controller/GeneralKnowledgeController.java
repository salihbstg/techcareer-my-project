package com.techcareer.controller;


import com.techcareer.dto.QuestionDto;
import com.techcareer.entity.GeneralKnowledge;
import com.techcareer.exception.ApplicationExceptionImpl;
import com.techcareer.service.ServiceAbstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/generalknowledge")
public class GeneralKnowledgeController {

    private final ServiceAbstruct generalKnowledgeService;
    private final ModelMapper modelMapper;
    public GeneralKnowledgeController(@Qualifier("generalKnowledgeManager") ServiceAbstruct generalKnowledgeService,ModelMapper modelMapper){
        this.generalKnowledgeService=generalKnowledgeService;
        this.modelMapper=modelMapper;
    }



    @GetMapping("/all")
    public ResponseEntity<List<QuestionDto>> findAll() {
        List<QuestionDto> temp = generalKnowledgeService.findAll();
        if (temp == null) {
            throw new ApplicationExceptionImpl("Questions not found!");
        }
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @GetMapping("/{generalKnowledgeId}")
    public ResponseEntity<QuestionDto> findById(@PathVariable int generalKnowledgeId) {
        QuestionDto temp = generalKnowledgeService.findById(generalKnowledgeId);
        if (temp == null) {
            throw new ApplicationExceptionImpl("Question not found!");
        }
        return new ResponseEntity<>(temp,HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<String> createGeneralKnowledge(@RequestBody GeneralKnowledge generalKnowledge){
        QuestionDto questionDto=modelMapper.map(generalKnowledge,QuestionDto.class);
        generalKnowledgeService.save(questionDto);
        return new ResponseEntity<>("Question created!",HttpStatus.OK) ;
    }

    @PutMapping("/save")
    public ResponseEntity<String> updateGeneralKnowledge(@RequestBody GeneralKnowledge generalKnowledge){
        QuestionDto questionDto=modelMapper.map(generalKnowledge,QuestionDto.class);
        generalKnowledgeService.save(questionDto);
        return new ResponseEntity<>("Question updated!",HttpStatus.OK) ;
    }

    @DeleteMapping("/{deletedId}")
    public ResponseEntity<String> deleteGeneralKnowledge(@PathVariable int deletedId){
        generalKnowledgeService.deleteById(deletedId);
        return new ResponseEntity<>("Question deleted!",HttpStatus.OK) ;
    }


}
