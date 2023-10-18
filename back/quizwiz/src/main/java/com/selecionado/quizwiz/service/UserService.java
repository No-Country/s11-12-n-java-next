package com.selecionado.quizwiz.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selecionado.quizwiz.dto.request.UserDTOReq;
import com.selecionado.quizwiz.dto.response.UserDTORes;
import com.selecionado.quizwiz.exceptions.ConfirmPasswordException;
import com.selecionado.quizwiz.exceptions.ExistsEmailException;
import com.selecionado.quizwiz.exceptions.UserIDNotFoundException;
import com.selecionado.quizwiz.model.User;
import com.selecionado.quizwiz.repository.IUserRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void saveUser(UserDTOReq userDTO) throws ExistsEmailException, ConfirmPasswordException {
		this.userValidation(userDTO);
		userRepository.save(modelMapper.map(userDTO, User.class));	
	}

	@Override
	public UserDTORes getUserById(Long id) throws UserIDNotFoundException {	
		var user = userRepository.findById(id)
				.orElseThrow(() -> new UserIDNotFoundException("El id " + id + " no existe."));
		return modelMapper.map(user, UserDTORes.class);
	}

	@Override
	public void updateUser(UserDTOReq userDTO) throws UserIDNotFoundException, ExistsEmailException, ConfirmPasswordException {
		var user = userRepository.findById(userDTO.getId())
				.orElseThrow(() -> new UserIDNotFoundException("El id " + userDTO + " no existe." ));
		this.userUpdateValidation(userDTO, user);
		
		userRepository.save(modelMapper.map(userDTO, User.class));
	}

	@Override
	public void deleteUser(Long id) {
		var user = userRepository.findById(id).orElse(null);
		user.setEnabled(false);
		userRepository.save(user);
	}
	
	
	public void userValidation(UserDTOReq userDTO) throws ExistsEmailException, ConfirmPasswordException {

		if(userRepository.existsByEmail(userDTO.getEmail())) {
			throw new ExistsEmailException("El email ya se encuentra registrado");
		}
		if(!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
			throw new ConfirmPasswordException("Los campos password y confirmar password deben coincidir");
		}
	}
	
	public void userUpdateValidation(UserDTOReq userDTO, User user) throws ExistsEmailException, ConfirmPasswordException, UserIDNotFoundException {
		if(userRepository.existsByEmail(userDTO.getEmail()) && !userDTO.getEmail().equals(user.getEmail()) ) {
			throw new ExistsEmailException("El email ya se encuentra registrado");
		}
		if(!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
			throw new ConfirmPasswordException("Los campos password y confirmar password deben coincidir");
		}
	}
	
	
	

}
