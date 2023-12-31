package com.selecionado.quizwiz.service;

import java.util.List;

import com.selecionado.quizwiz.dto.request.QuestionDtoReq;
import com.selecionado.quizwiz.dto.response.QuestionDtoRes;
import com.selecionado.quizwiz.exceptions.QuestionNotFoundExcepion;
import com.selecionado.quizwiz.model.Question;

public interface IQuestionService {

	List<QuestionDtoRes> getAllQuestions();

	QuestionDtoRes getQuestionById(Long id) throws QuestionNotFoundExcepion;

	QuestionDtoRes createQuestion(QuestionDtoReq questionDto);

	QuestionDtoRes updateQuestion(Long id, QuestionDtoReq updatedQuestionDto) throws QuestionNotFoundExcepion;

	void deleteQuestion(Long id);

}
