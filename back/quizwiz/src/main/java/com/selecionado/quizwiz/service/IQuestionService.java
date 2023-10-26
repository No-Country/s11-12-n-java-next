package com.selecionado.quizwiz.service;

import java.util.List;

import com.selecionado.quizwiz.dto.request.QuestionDtoReq;
import com.selecionado.quizwiz.exceptions.QuestionNotFoundExcepion;
import com.selecionado.quizwiz.model.Question;

public interface IQuestionService {

	List<Question> getAllQuestions();

	Question getQuestionById(Long id) throws QuestionNotFoundExcepion;

	QuestionDtoReq createQuestion(QuestionDtoReq questionDto);

	QuestionDtoReq updateQuestion(Long id, QuestionDtoReq updatedQuestionDto) throws QuestionNotFoundExcepion;

	void deleteQuestion(Long id);

}
