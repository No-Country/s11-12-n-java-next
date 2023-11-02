package com.selecionado.quizwiz.service;


import com.selecionado.quizwiz.dto.request.UserDtoReq;
import com.selecionado.quizwiz.dto.response.UserDTORes;
import com.selecionado.quizwiz.exceptions.ConfirmPasswordException;
import com.selecionado.quizwiz.exceptions.ExistsEmailException;
import com.selecionado.quizwiz.exceptions.UserIDNotFoundException;

public interface IUserService {

	UserDTORes saveUser(UserDtoReq userDTO) throws ExistsEmailException, ConfirmPasswordException, UserIDNotFoundException;

	UserDTORes getUserById(Long id) throws UserIDNotFoundException;

	UserDTORes updateUser(UserDtoReq userDTO) throws UserIDNotFoundException, ExistsEmailException, ConfirmPasswordException;

	void deleteUser(Long id);
}
