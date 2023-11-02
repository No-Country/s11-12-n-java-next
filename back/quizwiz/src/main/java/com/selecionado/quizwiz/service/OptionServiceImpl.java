package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.OptionDtoReq;
import com.selecionado.quizwiz.dto.response.OptionDtoRes;
import com.selecionado.quizwiz.model.Option;
import com.selecionado.quizwiz.repository.IOptionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionServiceImpl implements IOptionService{
    @Autowired
    IOptionRepository optionRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Option> findAllOption() {
        return optionRepository.findAll();
    }

    @Override
    public OptionDtoRes saveOption(OptionDtoReq optionDtoReq) {
        Option option = modelMapper.map(optionDtoReq, Option.class);
        return modelMapper.map(optionRepository.save(option), OptionDtoRes.class);
    }

    @Override
    public Option findByIdOption(Long id) {
        return optionRepository.findById(id).orElseThrow( () -> new RuntimeException("Option no encontrado"));
    }

    @Override
    public OptionDtoRes updateOption(OptionDtoReq optionDtoReq, Long id) {
        Optional<Option> optionalOption = optionRepository.findById(id);
        if (!optionalOption.isPresent()) {
            throw new RuntimeException("Option no encontrado");
        }
        Option optionUpdate = modelMapper.map(optionDtoReq, Option.class);
        return modelMapper.map(optionRepository.save(optionUpdate), OptionDtoRes.class);
    }

    @Override
    public void deleteOption(Long id) {
        Optional<Option> optionalOption = optionRepository.findById(id);
        if (!optionalOption.isPresent()) {
            throw new RuntimeException("Option no encontrado");
        }
        optionRepository.deleteById(id);
    }
}
