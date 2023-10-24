package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.FormDtoReq;
import com.selecionado.quizwiz.dto.response.FormDtoRes;
import com.selecionado.quizwiz.exceptions.FormNotFoundException;
import com.selecionado.quizwiz.model.Form;
import com.selecionado.quizwiz.repository.IFormRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    public void saveForm(FormDtoReq formDto) {
    }

    @Override
    public FormDtoRes getFormById(Long id) throws FormNotFoundException {
        return modelMapper.map(formRepository.findById(id)
                .orElseThrow(() -> new FormNotFoundException("El formulario no se encuentra registrado")), FormDtoRes.class);
    }

    @Override
    public Page<FormDtoRes> getAllForms(Pageable pageable) {

        var forms = formRepository.findAll(pageable);
        List<FormDtoRes> formsDto = new ArrayList<>();

        for (Form form: forms) {
            formsDto.add(modelMapper.map(form, FormDtoRes.class));
        }
        return new PageImpl<>(formsDto, pageable, forms.getTotalElements());
    }

    @Override
    public void updateForm(FormDtoReq formDto) throws FormNotFoundException {
       var form =  formRepository.findById(1L)
               .orElseThrow(() -> new FormNotFoundException("EL formulario con id " + 1 + " no se encuentra registrado"));
       formRepository.save(modelMapper.map(formDto, Form.class));
    }

    @Override
    public void deleteForm(Long id) {
        formRepository.deleteById(id);
    }
}
