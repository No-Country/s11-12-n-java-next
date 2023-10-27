package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.FormDtoReq;
import com.selecionado.quizwiz.dto.response.FormDtoRes;
import com.selecionado.quizwiz.exceptions.FormNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFormService {

    FormDtoRes saveForm(FormDtoReq formDto);
    FormDtoRes getFormById(Long id) throws FormNotFoundException;
    Page<FormDtoRes> getAllForms(Pageable pageable);
    FormDtoRes updateForm(FormDtoReq formDto) throws FormNotFoundException;
    void deleteForm(Long id);

}
