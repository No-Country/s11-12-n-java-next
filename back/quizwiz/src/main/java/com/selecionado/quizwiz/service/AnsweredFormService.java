package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.repository.IAnsweredFormRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnsweredFormService {
    @Autowired
    IAnsweredFormRepository answeredFormRepository;
    @Autowired
    ModelMapper modelMapper;


}
