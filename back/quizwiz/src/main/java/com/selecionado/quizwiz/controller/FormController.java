package com.selecionado.quizwiz.controller;

import com.selecionado.quizwiz.dto.request.FormDtoReq;
import com.selecionado.quizwiz.dto.response.FormDtoRes;
import com.selecionado.quizwiz.dto.response.MemberFormDtoRes;
import com.selecionado.quizwiz.exceptions.FormNotFoundException;
import com.selecionado.quizwiz.exceptions.UserIDNotFoundException;
import com.selecionado.quizwiz.service.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/formularios")
public class FormController {

    @Autowired
    private IFormService formService;


    @PostMapping()
    public ResponseEntity<MemberFormDtoRes> saveForm(@RequestBody FormDtoReq formDto) throws UserIDNotFoundException {
        return new ResponseEntity<>(formService.saveForm(formDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormDtoRes> getFormById(@PathVariable Long id) throws FormNotFoundException {
        return ResponseEntity.ok(formService.getFormById(id));
    }

    @GetMapping()
    public ResponseEntity<Page<FormDtoRes>> getAllForms(Pageable pageable){
        return ResponseEntity.ok(formService.getAllForms(pageable));
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
