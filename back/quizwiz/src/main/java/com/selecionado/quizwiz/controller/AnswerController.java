package com.selecionado.quizwiz.controller;

import com.selecionado.quizwiz.dto.request.AnswerDtoReq;
import com.selecionado.quizwiz.dto.response.AnswerDtoRes;
import com.selecionado.quizwiz.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/respuestas")
public class AnswerController {

    @Autowired
    private IAnswerService answerService;


    @PostMapping()
    public ResponseEntity<AnswerDtoRes> saveAnswer(@RequestBody AnswerDtoReq answerDtoReq){
        return new ResponseEntity<>(answerService.saveAnswer(answerDtoReq), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerDtoRes> getAnswerById(@PathVariable Long id){
        return ResponseEntity.ok(answerService.findByIdAnswer(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswerDtoRes> updateAnswer(@RequestBody AnswerDtoReq answerDtoReq, @PathVariable Long id){
        return ResponseEntity.ok(answerService.updateAnswer(answerDtoReq, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> updateAnswer(@PathVariable Long id){
        answerService.deleteAnswer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
