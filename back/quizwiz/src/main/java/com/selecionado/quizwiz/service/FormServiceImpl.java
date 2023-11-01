package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.FormDtoReq;
import com.selecionado.quizwiz.dto.request.MemberDtoReq;
import com.selecionado.quizwiz.dto.response.FormDtoRes;
import com.selecionado.quizwiz.dto.response.MemberFormDtoRes;
import com.selecionado.quizwiz.exceptions.FormNotFoundException;
import com.selecionado.quizwiz.exceptions.UserIDNotFoundException;
import com.selecionado.quizwiz.model.Form;
import com.selecionado.quizwiz.model.User;
import com.selecionado.quizwiz.repository.IFormRepository;
import com.selecionado.quizwiz.repository.IUserRepository;
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
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MemberFormDtoRes saveForm(FormDtoReq formDto) throws UserIDNotFoundException {
        var users = new ArrayList<User>();
        var unregisteredUsers = new ArrayList<String>();
        var returnMemberForm = new MemberFormDtoRes();

//        for (MemberDtoReq member : formDto.getMembers()){
//
//           var user = userRepository.findByEmail(member.getEmail());
//           if(user.isEmpty()){
//               unregisteredUsers.add(member.getEmail());
//           }else{
//               users.add(user.get());
//           }
//        }
//        var form = modelMapper.map(formDto, Form.class);
//        form.setMembers(users);
//        var savedForm = formRepository.save(form);
//        returnMemberForm.setId(savedForm.getId());
//
//        if(unregisteredUsers.isEmpty()){
//            returnMemberForm.setMessage("El formulario ha sido guardado correctamente.");
//            return returnMemberForm;
//        }
//        else{
//            returnMemberForm.setMessage("Los siguientes emails no pudieron asignarse al formulario porque no se encuentran registrados en la plataforma.");
//            returnMemberForm.setEmails(unregisteredUsers);
            return returnMemberForm;
//        }
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
