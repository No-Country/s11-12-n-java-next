package com.selecionado.quizwiz.controller;

import com.selecionado.quizwiz.dto.request.OptionDtoReq;
import com.selecionado.quizwiz.model.Option;
import com.selecionado.quizwiz.service.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/opciones")
public class OptionController {

    @Autowired
    private IOptionService optionService;


    @PostMapping()
    public ResponseEntity<Option> saveOption(@RequestBody OptionDtoReq optionDto){
        return new ResponseEntity<>(optionService.saveOption(optionDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Option> getOptionById(@PathVariable Long id){
        return ResponseEntity.ok(optionService.findByIdOption(id));
    }

    @GetMapping()
    public ResponseEntity<List<Option>> getOptionById(){
        return ResponseEntity.ok(optionService.findAllOption());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Option> updateOption(@PathVariable Long id, @RequestBody OptionDtoReq option){
        return ResponseEntity.ok(optionService.updateOption(option, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> updateOption(@PathVariable Long id){
        optionService.deleteOption(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
