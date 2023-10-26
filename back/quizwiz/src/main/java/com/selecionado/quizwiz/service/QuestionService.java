package com.selecionado.quizwiz.service;

import java.util.List;

import com.selecionado.quizwiz.dto.request.QuestionDtoReq;
import com.selecionado.quizwiz.exceptions.QuestionNotFoundExcepion;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selecionado.quizwiz.model.Question;
import com.selecionado.quizwiz.repository.IQuestionRepository;

@Service
public class QuestionService implements IQuestionService{

	
    @Autowired
    private IQuestionRepository questionRepository;
	@Autowired
	private ModelMapper modelMapper;


	@Override
	public List<Question> getAllQuestions() {
        return questionRepository.findAll();

	}

	@Override
	public Question getQuestionById(Long id) throws QuestionNotFoundExcepion {
        return questionRepository.findById(id).orElseThrow(() -> new QuestionNotFoundExcepion("El id de la pregunta no se encuentra registrado"));

	}

	@Override
	public QuestionDtoReq createQuestion(QuestionDtoReq questionDto) {
        questionRepository.save(modelMapper.map(questionDto, Question.class));
		return questionDto;
	}

	@Override
	public QuestionDtoReq updateQuestion(Long id, QuestionDtoReq updatedQuestionDto) throws QuestionNotFoundExcepion {
        if (questionRepository.existsById(id)) {
            updatedQuestionDto.setId(id);
			questionRepository.save(modelMapper.map(updatedQuestionDto, Question.class));
			return updatedQuestionDto;
        }
        throw new QuestionNotFoundExcepion("El id de La pregunta no se encuentra registrada");
	}

	@Override
	public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
		
	}

}
