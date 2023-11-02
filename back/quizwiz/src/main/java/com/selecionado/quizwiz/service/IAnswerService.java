package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.AnswerDtoReq;
import com.selecionado.quizwiz.dto.response.AnswerDtoRes;
import com.selecionado.quizwiz.model.Answer;

import java.util.List;

public interface IAnswerService {
    AnswerDtoRes findByIdAnswer(Long id);
    AnswerDtoRes saveAnswer(AnswerDtoReq answerDtoReq);
    AnswerDtoRes updateAnswer(AnswerDtoReq answerDtoReq, Long id);
    void deleteAnswer(Long id);
}
