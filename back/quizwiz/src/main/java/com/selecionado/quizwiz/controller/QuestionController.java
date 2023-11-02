package com.selecionado.quizwiz.controller;

import java.util.List;

import com.selecionado.quizwiz.dto.request.QuestionDtoReq;
import com.selecionado.quizwiz.dto.response.QuestionDtoRes;
import com.selecionado.quizwiz.exceptions.QuestionNotFoundExcepion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selecionado.quizwiz.model.Question;
import com.selecionado.quizwiz.service.IQuestionService;

@RestController
@RequestMapping("/api/v1/preguntas")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    @GetMapping
    public ResponseEntity<List<QuestionDtoRes>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDtoRes> getQuestionById(@PathVariable Long id) throws QuestionNotFoundExcepion {
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

    @PostMapping
    public ResponseEntity<QuestionDtoRes> createQuestion(@RequestBody QuestionDtoReq question) {
        return new ResponseEntity<>(questionService.createQuestion(question), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<QuestionDtoRes> updateQuestion(@PathVariable Long id, @RequestBody QuestionDtoReq updatedQuestion) throws QuestionNotFoundExcepion {
        return new ResponseEntity<>(questionService.updateQuestion(id, updatedQuestion), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }
}
