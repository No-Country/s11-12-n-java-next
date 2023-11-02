package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.AnsweredFormDtoReq;
import com.selecionado.quizwiz.dto.response.AnsweredFormDtoRes;
import com.selecionado.quizwiz.model.AnsweredForm;
import com.selecionado.quizwiz.repository.IAnsweredFormRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnsweredFormService implements IAnsweredFormService{

    @Autowired
    IAnsweredFormRepository answeredFormRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public AnsweredFormDtoRes saveAnsweredForm(AnsweredFormDtoReq answeredForm){
        var answeredFormDB = answeredFormRepository.save(modelMapper.map(answeredForm, AnsweredForm.class));
        return modelMapper.map(answeredFormDB, AnsweredFormDtoRes.class);
    }

    @Override
    public AnsweredFormDtoRes getAnsweredFormById(Long id) throws Exception {
        return modelMapper.map(answeredFormRepository.findById(id).orElseThrow(() -> new Exception("El formulario respondido no ha sido encontrado")), AnsweredFormDtoRes.class);
    }

    @Override
    public List<AnsweredFormDtoRes> getAllAnsweredForm() {
        var answeredForms = answeredFormRepository.findAll();
        var answeredFormsDto = new ArrayList<AnsweredFormDtoRes>();

        for(AnsweredForm answeredForm : answeredForms){
            answeredFormsDto.add(modelMapper.map(answeredForm, AnsweredFormDtoRes.class));
        }
        return answeredFormsDto;

    }

}
