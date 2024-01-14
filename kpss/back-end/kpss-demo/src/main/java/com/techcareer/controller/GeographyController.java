package com.techcareer.controller;
import com.techcareer.dto.QuestionDto;
import com.techcareer.entity.Geography;
import com.techcareer.exception.ApplicationExceptionImpl;
import com.techcareer.service.ServiceAbstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geography")
public class GeographyController {
    private final ServiceAbstruct geographyService;
    private final ModelMapper modelMapper;
    public GeographyController(@Qualifier("geographyManager") ServiceAbstruct geographyService, ModelMapper modelMapper){
        this.geographyService = geographyService;
        this.modelMapper=modelMapper;
    }
    @GetMapping("/all")
    public ResponseEntity<List<QuestionDto>> findAll() {
        List<QuestionDto> temp = geographyService.findAll();
        if (temp == null) {
            throw new ApplicationExceptionImpl("Questions not found!");
        }
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @GetMapping("/{geographyId}")
    public ResponseEntity<QuestionDto> findById(@PathVariable int geographyId) {
        QuestionDto temp = geographyService.findById(geographyId);
        if (temp == null) {
            throw new ApplicationExceptionImpl("Question not found!");
        }
        return new ResponseEntity<>(temp,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> createGeography(@RequestBody Geography geography){
        QuestionDto questionDto=modelMapper.map(geography,QuestionDto.class);
        geographyService.save(questionDto);
        return new ResponseEntity<>("Question created!",HttpStatus.OK) ;
    }

    @PutMapping("/save")
    public ResponseEntity<String> updateGeography(@RequestBody Geography geography){
        QuestionDto questionDto=modelMapper.map(geography,QuestionDto.class);
        geographyService.save(questionDto);
        return new ResponseEntity<>("Question updated!",HttpStatus.OK) ;
    }

    @DeleteMapping("/{deletedId}")
    public ResponseEntity<String> deleteGeography(@PathVariable int deletedId){
        geographyService.deleteById(deletedId);
        return new ResponseEntity<>("Question deleted!",HttpStatus.OK) ;
    }
}
