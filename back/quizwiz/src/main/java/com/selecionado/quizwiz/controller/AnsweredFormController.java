package com.selecionado.quizwiz.controller;

import com.selecionado.quizwiz.dto.request.AnsweredFormDtoReq;
import com.selecionado.quizwiz.dto.response.AnsweredFormDtoRes;
import com.selecionado.quizwiz.service.IAnsweredFormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/formularios_contestados")
public class AnsweredFormController {

    private IAnsweredFormService answeredFormService;


    @PostMapping()
    public ResponseEntity<AnsweredFormDtoRes> saveAnsweredForm(@RequestBody AnsweredFormDtoReq answeredFormDtoReq){
        return new ResponseEntity<>(answeredFormService.saveAnsweredForm(answeredFormDtoReq), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnsweredFormDtoRes> getAnsweredFormById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(answeredFormService.getAnsweredFormById(id));
    }

    @GetMapping()
    public ResponseEntity<List<AnsweredFormDtoRes>> getAllAnsweredFormById() {
        return ResponseEntity.ok(answeredFormService.getAllAnsweredForm());
    }
}
