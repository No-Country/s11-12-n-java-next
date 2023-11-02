package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.FormDtoReq;
import com.selecionado.quizwiz.dto.response.FormDtoRes;
import com.selecionado.quizwiz.exceptions.FormNotFoundException;

import java.util.List;

public interface IFormService {

    FormDtoRes saveForm(FormDtoReq formDto);
    FormDtoRes getFormById(Long id) throws FormNotFoundException;
    List<FormDtoRes> getAllForms();
    FormDtoRes updateForm(FormDtoReq formDto) throws FormNotFoundException;
    void deleteForm(Long id);

}
