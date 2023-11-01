package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.AnsweredFormDtoReq;
import com.selecionado.quizwiz.dto.response.AnsweredFormDtoRes;

import java.util.List;

public interface IAnsweredFormService {

    AnsweredFormDtoRes saveAnsweredForm(AnsweredFormDtoReq answeredForm);

    AnsweredFormDtoRes getAnsweredFormById(Long id) throws Exception;
    List<AnsweredFormDtoRes> getAllAnsweredForm();

}
