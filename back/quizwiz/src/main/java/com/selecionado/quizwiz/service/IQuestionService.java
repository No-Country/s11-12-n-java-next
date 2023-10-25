package com.selecionado.quizwiz.service;

import java.util.List;

import com.selecionado.quizwiz.model.Question;

public interface IQuestionService {

	List<Question> getAllQuestions();

	Question getQuestionById(Long id);

	Question createQuestion(Question question);

	Question updateQuestion(Long id, Question updatedQuestion);

	void deleteQuestion(Long id);

}
