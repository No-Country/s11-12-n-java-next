package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.AnswerDtoReq;
import com.selecionado.quizwiz.dto.request.OptionDtoReq;
import com.selecionado.quizwiz.dto.response.AnswerDtoRes;
import com.selecionado.quizwiz.dto.response.OptionDtoRes;
import com.selecionado.quizwiz.model.Answer;
import com.selecionado.quizwiz.model.Option;
import com.selecionado.quizwiz.repository.IAnswerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService implements IAnswerService{
    @Autowired
    IAnswerRepository answerRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Answer findByIdAnswer(Long id){
        return answerRepository.findById(id).orElseThrow(() -> new RuntimeException("Respuesta No encontrada"));
    }

    @Override
    public AnswerDtoRes saveAnswer(AnswerDtoReq answerDtoReq) {
        Answer answer = modelMapper.map(answerDtoReq, Answer.class);
        return modelMapper.map(answerRepository.save(answer), AnswerDtoRes.class);
    }

    @Override
    public AnswerDtoRes updateAnswer(AnswerDtoReq answerDtoReq, Long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (!optionalAnswer.isPresent()) {
            throw new RuntimeException("Answer no encontrado");
        }
        Answer answerUpdate = modelMapper.map(answerDtoReq, Answer.class);
        return modelMapper.map(answerRepository.save(answerUpdate), AnswerDtoRes.class);
    }
    @Override
    public void deleteAnswer(Long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (!optionalAnswer.isPresent()) {
            throw new RuntimeException("Answer no encontrada");
        }
        answerRepository.deleteById(id);
    }
}
