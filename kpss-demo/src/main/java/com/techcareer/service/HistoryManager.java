package com.techcareer.service;

import com.techcareer.dto.QuestionDto;

import com.techcareer.entity.History;
import com.techcareer.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HistoryManager implements ServiceAbstruct{
    private final ModelMapper modelMapper;
    private final HistoryRepository historyRepository;
    @Override
    public Long save(QuestionDto questionDto) {
        History history = modelMapper.map(questionDto, History.class);
        historyRepository.save(history);
        return history.getId();
    }

    @Override
    public QuestionDto findById(int id) {
        Optional<History> optionalHistory = historyRepository.findById(id);
        if (optionalHistory.isPresent()) {
            History history = optionalHistory.get();
            return modelMapper.map(history, QuestionDto.class);
        } else {
            return null;
        }
    }

    @Override
    public List<QuestionDto> findAll() {
        List<History> historyList = historyRepository.findAll();
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (History temp : historyList) {
            questionDtoList.add(modelMapper.map(temp, QuestionDto.class));
        }
        return questionDtoList;
    }

    @Override
    public void deleteById(int id) {
        historyRepository.deleteById(id);
    }
}
