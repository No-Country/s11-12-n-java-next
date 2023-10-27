package com.selecionado.quizwiz.service;

import java.util.ArrayList;
import java.util.List;

import com.selecionado.quizwiz.dto.request.QuestionDtoReq;
import com.selecionado.quizwiz.dto.response.QuestionDtoRes;
import com.selecionado.quizwiz.exceptions.QuestionNotFoundExcepion;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selecionado.quizwiz.model.Question;
import com.selecionado.quizwiz.repository.IQuestionRepository;

@Service
public class QuestionServiceImpl implements IQuestionService{

	
    @Autowired
    private IQuestionRepository questionRepository;
	@Autowired
	private ModelMapper modelMapper;


	@Override
	public List<QuestionDtoRes> getAllQuestions() {
        var questions = questionRepository.findAll();
		var questionsDto = new ArrayList<QuestionDtoRes>();

		for (Question question : questions){
			questionsDto.add(modelMapper.map(question, QuestionDtoRes.class));
		}
		return questionsDto;
	}

	@Override
	public QuestionDtoRes getQuestionById(Long id) throws QuestionNotFoundExcepion {
        var question = questionRepository.findById(id)
				.orElseThrow(() -> new QuestionNotFoundExcepion("El id de la pregunta no se encuentra registrado"));
		return modelMapper.map(question, QuestionDtoRes.class);

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
