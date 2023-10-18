package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.DTO.request.UserDtoReq;
import com.selecionado.quizwiz.model.User;

import java.util.List;

public interface IUserService {

	List<User> findAll();
    User save(UserDtoReq userDtoReq);
    User findById(Long id);
    User update(UserDtoReq userDtoReq, Long id);
    void delete(Long id);


}
