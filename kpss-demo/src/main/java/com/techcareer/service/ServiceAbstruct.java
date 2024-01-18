package com.techcareer.service;

import com.techcareer.dto.QuestionDto;

import java.util.List;

public interface ServiceAbstruct {
    Long save(QuestionDto questionDto);
    QuestionDto findById(int id);
    List<QuestionDto> findAll();
    void deleteById(int id);

}
