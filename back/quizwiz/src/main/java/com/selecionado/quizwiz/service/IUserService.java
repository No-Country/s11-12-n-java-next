package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.UserDTOReq;
import com.selecionado.quizwiz.dto.response.UserDTORes;
import com.selecionado.quizwiz.exceptions.ConfirmPasswordException;
import com.selecionado.quizwiz.exceptions.ExistsEmailException;
import com.selecionado.quizwiz.exceptions.UserIDNotFoundException;

public interface IUserService {

	void saveUser(UserDTOReq userDTO) throws ExistsEmailException, ConfirmPasswordException;
	UserDTORes getUserById(Long id) throws UserIDNotFoundException;
	void updateUser(UserDTOReq userDTO) throws UserIDNotFoundException, ExistsEmailException, ConfirmPasswordException;
	void deleteUser(Long id);
	
}
