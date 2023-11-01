package com.selecionado.quizwiz.controller;

import com.selecionado.quizwiz.dto.request.FormDtoReq;
import com.selecionado.quizwiz.dto.response.FormDtoRes;
import com.selecionado.quizwiz.exceptions.FormNotFoundException;
import com.selecionado.quizwiz.service.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/formularios")
public class FormController {

    @Autowired
    private IFormService formService;


    @PostMapping()
    public ResponseEntity<FormDtoRes> saveForm(@RequestBody FormDtoReq formDto) {
        return new ResponseEntity<>(formService.saveForm(formDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormDtoRes> getFormById(@PathVariable Long id) throws FormNotFoundException {
        return ResponseEntity.ok(formService.getFormById(id));
    }

    @GetMapping()
    public ResponseEntity<List<FormDtoRes>> getAllForms(){
        return ResponseEntity.ok(formService.getAllForms());
    }

    @PutMapping()
    public ResponseEntity<FormDtoRes> updateForm(@RequestBody FormDtoReq formDto) throws FormNotFoundException {
        return new ResponseEntity<>(formService.updateForm(formDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteForm(Long id){
        formService.deleteForm(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
