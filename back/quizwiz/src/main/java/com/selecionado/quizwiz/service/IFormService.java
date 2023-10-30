package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.FormDtoReq;
import com.selecionado.quizwiz.dto.response.FormDtoRes;
import com.selecionado.quizwiz.dto.response.MemberFormDtoRes;
import com.selecionado.quizwiz.exceptions.FormNotFoundException;
import com.selecionado.quizwiz.exceptions.UserIDNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFormService {

    MemberFormDtoRes saveForm(FormDtoReq formDto) throws UserIDNotFoundException;
    FormDtoRes getFormById(Long id) throws FormNotFoundException;
    Page<FormDtoRes> getAllForms(Pageable pageable);
    FormDtoRes updateForm(FormDtoReq formDto) throws FormNotFoundException;
    void deleteForm(Long id);

}
