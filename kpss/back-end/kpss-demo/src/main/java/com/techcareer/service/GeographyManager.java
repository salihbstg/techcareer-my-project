package com.techcareer.service;
import com.techcareer.dto.QuestionDto;
import com.techcareer.entity.Geography;
import com.techcareer.repository.GeographyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GeographyManager implements ServiceAbstruct {
    private final ModelMapper modelMapper;
    private final GeographyRepository geographyRepository;

    @Override
    public Long save(QuestionDto questionDto) {
        Geography geography = modelMapper.map(questionDto, Geography.class);
        geographyRepository.save(geography);
        return geography.getId();
    }

    @Override
    public QuestionDto findById(int id) {
        Optional<Geography> optionalGeography = geographyRepository.findById(id);
        if (optionalGeography.isPresent()) {
            Geography geography = optionalGeography.get();
            return modelMapper.map(geography, QuestionDto.class);
        } else {
            return null;
        }
    }

    @Override
    public List<QuestionDto> findAll() {
        List<Geography> geographyList = geographyRepository.findAll();
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (Geography temp : geographyList) {
            questionDtoList.add(modelMapper.map(temp, QuestionDto.class));
        }
        return questionDtoList;
    }

    @Override
    public void deleteById(int id) {
    geographyRepository.deleteById(id);
    }
}
