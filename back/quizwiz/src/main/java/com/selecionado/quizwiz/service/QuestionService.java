package com.selecionado.quizwiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selecionado.quizwiz.model.Question;
import com.selecionado.quizwiz.repository.IQuestionRepository;

@Service
public class QuestionService implements IQuestionService{

	
    @Autowired
    private IQuestionRepository questionRepository;


	@Override
	public List<Question> getAllQuestions() {
        return questionRepository.findAll();

	}

	@Override
	public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);

	}

	@Override
	public Question createQuestion(Question question) {
        return questionRepository.save(question);

	}

	@Override
	public Question updateQuestion(Long id, Question updatedQuestion) {
        if (questionRepository.existsById(id)) {
            updatedQuestion.setId(id);
            return questionRepository.save(updatedQuestion);
        }
        return null;
	}

	@Override
	public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
		
	}

}
