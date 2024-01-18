package com.techcareer.controller;

import com.techcareer.dto.QuestionDto;
import com.techcareer.entity.Turkish;
import com.techcareer.exception.ApplicationExceptionImpl;
import com.techcareer.service.ServiceAbstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turkish")
public class TurkishController {
    private final ServiceAbstruct turkishService;
    private final ModelMapper modelMapper;
    public TurkishController(@Qualifier("turkishManager") ServiceAbstruct turkishService, ModelMapper modelMapper){
        this.turkishService = turkishService;
        this.modelMapper=modelMapper;
    }
    @GetMapping("/all")
    public ResponseEntity<List<QuestionDto>> findAll() {
        List<QuestionDto> temp = turkishService.findAll();
        if (temp == null) {
            throw new ApplicationExceptionImpl("Questions not found!");
        }
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
    @GetMapping("/{turkishId}")
    public ResponseEntity<QuestionDto> findById(@PathVariable int turkishId) {
        QuestionDto temp = turkishService.findById(turkishId);
        if (temp == null) {
            throw new ApplicationExceptionImpl("Question not found!");
        }
        return new ResponseEntity<>(temp,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<String> createTurkish(@RequestBody Turkish turkish){
        QuestionDto questionDto=modelMapper.map(turkish,QuestionDto.class);
        turkishService.save(questionDto);
        return new ResponseEntity<>("Question created!",HttpStatus.OK) ;
    }
    @PutMapping("/save")
    public ResponseEntity<String> updateTurkish(@RequestBody Turkish turkish){
        QuestionDto questionDto=modelMapper.map(turkish,QuestionDto.class);
        turkishService.save(questionDto);
        return new ResponseEntity<>("Question updated!",HttpStatus.OK) ;
    }
    @DeleteMapping("/{deletedId}")
    public ResponseEntity<String> deleteTurkish(@PathVariable int deletedId){
        turkishService.deleteById(deletedId);
        return new ResponseEntity<>("Question deleted!",HttpStatus.OK) ;
    }
}
