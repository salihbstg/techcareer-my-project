package com.techcareer.service;
import com.techcareer.dto.QuestionDto;
import com.techcareer.entity.Turkish;
import com.techcareer.repository.TurkishRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TurkishManager implements ServiceAbstruct {
    private final ModelMapper modelMapper;
    private final TurkishRepository turkishRepository;

    @Override
    public Long save(QuestionDto questionDto) {
        Turkish turkish = modelMapper.map(questionDto, Turkish.class);
        turkishRepository.save(turkish);
        return turkish.getId();
    }

    @Override
    public QuestionDto findById(int id) {
        Optional<Turkish> optionalTurkish = turkishRepository.findById(id);
        if (optionalTurkish.isPresent()) {
            Turkish turkish = optionalTurkish.get();
            return modelMapper.map(turkish, QuestionDto.class);
        } else {
            return null;
        }
    }

    @Override
    public List<QuestionDto> findAll() {
        List<Turkish> turkishList = turkishRepository.findAll();
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (Turkish temp : turkishList) {
            questionDtoList.add(modelMapper.map(temp, QuestionDto.class));
        }
        return questionDtoList;
    }

    @Override
    public void deleteById(int id) {
    turkishRepository.deleteById(id);
    }
}
