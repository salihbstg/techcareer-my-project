package com.techcareer.service;

import com.techcareer.dto.QuestionDto;
import com.techcareer.entity.Mathematics;
import com.techcareer.repository.MathematicsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MathematicsManager implements ServiceAbstruct{
    private final ModelMapper modelMapper;
    private final MathematicsRepository mathematicsRepository;
    @Override
    public Long save(QuestionDto questionDto) {
        Mathematics mathematics = modelMapper.map(questionDto, Mathematics.class);
        mathematicsRepository.save(mathematics);
        return mathematics.getId();
    }

    @Override
    public QuestionDto findById(int id) {
        Optional<Mathematics> optionalMathematics = mathematicsRepository.findById(id);
        if (optionalMathematics.isPresent()) {
            Mathematics mathematics = optionalMathematics.get();
            return modelMapper.map(mathematics, QuestionDto.class);
        } else {
            return null;
        }
    }

    @Override
    public List<QuestionDto> findAll() {
        List<Mathematics> mathematicsList = mathematicsRepository.findAll();
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (Mathematics temp : mathematicsList) {
            questionDtoList.add(modelMapper.map(temp, QuestionDto.class));
        }
        return questionDtoList;
    }

    @Override
    public void deleteById(int id) {
    mathematicsRepository.deleteById(id);
    }
}
