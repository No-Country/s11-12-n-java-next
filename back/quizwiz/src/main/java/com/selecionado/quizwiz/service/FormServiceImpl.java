package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.FormDtoReq;
import com.selecionado.quizwiz.dto.response.FormDtoRes;
import com.selecionado.quizwiz.exceptions.FormNotFoundException;
import com.selecionado.quizwiz.model.Form;
import com.selecionado.quizwiz.repository.IFormRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormServiceImpl implements IFormService{

    @Autowired
    private IFormRepository formRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FormDtoRes saveForm(FormDtoReq formDto) {
        return modelMapper.map(formRepository.save(modelMapper.map(formDto, Form.class)), FormDtoRes.class);
    }

    @Override
    public FormDtoRes getFormById(Long id) throws FormNotFoundException {
        return modelMapper.map(formRepository.findById(id)
                .orElseThrow(() -> new FormNotFoundException("El formulario no se encuentra registrado")), FormDtoRes.class);
    }

    @Override
    public List<FormDtoRes> getAllForms() {

        var forms = formRepository.findAll();
        List<FormDtoRes> formsDto = new ArrayList<>();

        for (Form form: forms) {
            formsDto.add(modelMapper.map(form, FormDtoRes.class));
        }
        return formsDto;
    }

    @Override
    public FormDtoRes updateForm(FormDtoReq formDto) throws FormNotFoundException {
        if(formRepository.existsById(formDto.getId())){
            throw new FormNotFoundException("El formulario no se encuentra registrado");
        }
        var form = formRepository.save(modelMapper.map(formDto, Form.class));
        return modelMapper.map(form, FormDtoRes.class);
    }

    @Override
    public void deleteForm(Long id) {
        formRepository.deleteById(id);
    }
}
