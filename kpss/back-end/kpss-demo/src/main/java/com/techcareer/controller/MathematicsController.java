package com.techcareer.controller;

import com.techcareer.dto.QuestionDto;
import com.techcareer.entity.Mathematics;
import com.techcareer.exception.ApplicationExceptionImpl;
import com.techcareer.service.ServiceAbstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/math")
public class MathematicsController {
    private final ServiceAbstruct mathematicsService;
    private final ModelMapper modelMapper;
    public MathematicsController(@Qualifier("mathematicsManager") ServiceAbstruct mathematicsService, ModelMapper modelMapper){
        this.mathematicsService = mathematicsService;
        this.modelMapper=modelMapper;
    }
    @GetMapping("/all")
    public ResponseEntity<List<QuestionDto>> findAll() {
        List<QuestionDto> temp = mathematicsService.findAll();
        if (temp == null) {
            throw new ApplicationExceptionImpl("Questions not found!");
        }
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
    @GetMapping("/{turkishId}")
    public ResponseEntity<QuestionDto> findById(@PathVariable int turkishId) {
        QuestionDto temp = mathematicsService.findById(turkishId);
        if (temp == null) {
            throw new ApplicationExceptionImpl("Question not found!");
        }
        return new ResponseEntity<>(temp,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<String> createMathematics(@RequestBody Mathematics mathematics){
        QuestionDto questionDto=modelMapper.map(mathematics,QuestionDto.class);
        mathematicsService.save(questionDto);
        return new ResponseEntity<>("Question created!",HttpStatus.OK) ;
    }
    @PutMapping("/save")
    public ResponseEntity<String> updateMathematics(@RequestBody Mathematics mathematics){
        QuestionDto questionDto=modelMapper.map(mathematics,QuestionDto.class);
        mathematicsService.save(questionDto);
        return new ResponseEntity<>("Question updated!",HttpStatus.OK) ;
    }
    @DeleteMapping("/{deletedId}")
    public ResponseEntity<String> deleteMathematics(@PathVariable int deletedId){
        mathematicsService.deleteById(deletedId);
        return new ResponseEntity<>("Question deleted!",HttpStatus.OK) ;
    }
}
