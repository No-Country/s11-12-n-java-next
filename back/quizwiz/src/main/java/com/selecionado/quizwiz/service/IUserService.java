package com.selecionado.quizwiz.service;


import com.selecionado.quizwiz.dto.request.UserDtoRe;
import com.selecionado.quizwiz.dto.response.UserDTORes;
import com.selecionado.quizwiz.exceptions.ConfirmPasswordException;
import com.selecionado.quizwiz.exceptions.ExistsEmailException;
import com.selecionado.quizwiz.exceptions.UserIDNotFoundException;

public interface IUserService {

	void saveUser(UserDtoRe userDTO) throws ExistsEmailException, ConfirmPasswordException, UserIDNotFoundException;

	UserDTORes getUserById(Long id) throws UserIDNotFoundException;

	void updateUser(UserDtoRe userDTO) throws UserIDNotFoundException, ExistsEmailException, ConfirmPasswordException;

	void deleteUser(Long id);
}
