package com.techcareer.service;

import com.techcareer.dto.QuestionDto;
import com.techcareer.entity.GeneralKnowledge;
import com.techcareer.repository.GeneralKnowledgeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GeneralKnowledgeManager implements ServiceAbstruct {
    private final GeneralKnowledgeRepository generalKnowledgeRepository;
    private final ModelMapper modelMapper;
    @Override
    public Long save(QuestionDto questionDto) {
        GeneralKnowledge generalKnowledge=modelMapper.map(questionDto,GeneralKnowledge.class);
        generalKnowledgeRepository.save(generalKnowledge);
        return generalKnowledge.getId();
    }

    @Override
    public QuestionDto findById(int id) {
        Optional<GeneralKnowledge> optionalGeneralKnowledge=generalKnowledgeRepository.findById(id);
        if (optionalGeneralKnowledge.isPresent()) {
            GeneralKnowledge generalKnowledge = optionalGeneralKnowledge.get();
            return modelMapper.map(generalKnowledge, QuestionDto.class);
        } else {
            return null;
        }
    }

    @Override
    public List<QuestionDto> findAll() {
        List<GeneralKnowledge> generalKnowledgeList=generalKnowledgeRepository.findAll();
        List<QuestionDto> questionDtoList=new ArrayList<>();
        for(GeneralKnowledge temp:generalKnowledgeList){
            questionDtoList.add(modelMapper.map(temp,QuestionDto.class));
        }
        return questionDtoList;
    }

    @Override
    public void deleteById(int id) {
        generalKnowledgeRepository.deleteById(id);
    }
}
