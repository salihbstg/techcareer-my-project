package com.techcareer.controller;

import com.techcareer.dto.QuestionDto;
import com.techcareer.entity.History;
import com.techcareer.exception.ApplicationExceptionImpl;
import com.techcareer.service.ServiceAbstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {
    private final ServiceAbstruct historyService;
    private final ModelMapper modelMapper;
    public HistoryController(@Qualifier("historyManager") ServiceAbstruct historyService, ModelMapper modelMapper){
        this.historyService = historyService;
        this.modelMapper=modelMapper;
    }
    @GetMapping("/all")
    public ResponseEntity<List<QuestionDto>> findAll() {
        List<QuestionDto> temp = historyService.findAll();
        if (temp == null) {
            throw new ApplicationExceptionImpl("Questions not found!");
        }
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
    @GetMapping("/{historyId}")
    public ResponseEntity<QuestionDto> findById(@PathVariable int historyId) {
        QuestionDto temp = historyService.findById(historyId);
        if (temp == null) {
            throw new ApplicationExceptionImpl("Question not found!");
        }
        return new ResponseEntity<>(temp,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<String> createHistory(@RequestBody History history){
        QuestionDto questionDto=modelMapper.map(history,QuestionDto.class);
        historyService.save(questionDto);
        return new ResponseEntity<>("Question created!",HttpStatus.OK) ;
    }
    @PutMapping("/save")
    public ResponseEntity<String> updateHistory(@RequestBody History history){
        QuestionDto questionDto=modelMapper.map(history,QuestionDto.class);
        historyService.save(questionDto);
        return new ResponseEntity<>("Question updated!",HttpStatus.OK) ;
    }
    @DeleteMapping("/{deletedId}")
    public ResponseEntity<String> deleteHistory(@PathVariable int deletedId){
        historyService.deleteById(deletedId);
        return new ResponseEntity<>("Question deleted!",HttpStatus.OK) ;
    }
}
