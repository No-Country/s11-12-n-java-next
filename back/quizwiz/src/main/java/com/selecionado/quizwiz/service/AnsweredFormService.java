package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.AnsweredFormDtoReq;
import com.selecionado.quizwiz.model.AnsweredForm;
import com.selecionado.quizwiz.repository.IAnsweredFormRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnsweredFormService implements IAnsweredFormService{

    @Autowired
    IAnsweredFormRepository answeredFormRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveAnsweredForm(AnsweredFormDtoReq answeredForm){
        answeredFormRepository.save(modelMapper.map(answeredForm, AnsweredForm.class));
    }

}
