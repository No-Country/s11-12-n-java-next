package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.UserDtoReq;
import com.selecionado.quizwiz.repository.IRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selecionado.quizwiz.dto.response.UserDTORes;
import com.selecionado.quizwiz.exceptions.ConfirmPasswordException;
import com.selecionado.quizwiz.exceptions.ExistsEmailException;
import com.selecionado.quizwiz.exceptions.UserIDNotFoundException;
import com.selecionado.quizwiz.model.User;
import com.selecionado.quizwiz.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IRoleRepository roleRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void saveUser(UserDtoReq userDTO) throws ExistsEmailException, ConfirmPasswordException, UserIDNotFoundException {

		var role = roleRepository.findByRoleName("USER")
				.orElseThrow(() -> new UserIDNotFoundException("Debe crear los roles de usuario"));
		this.userValidation(userDTO);
		var user = modelMapper.map(userDTO, User.class);
		user.setEnabled(true);
		user.setRole(role);

		userRepository.save(user);
	}

	@Override
	public UserDTORes getUserById(Long id) throws UserIDNotFoundException {	
		var user = userRepository.findById(id)
				.orElseThrow(() -> new UserIDNotFoundException("El id " + id + " no existe."));
		return modelMapper.map(user, UserDTORes.class);
	}

	@Override
	public void updateUser(UserDtoReq userDTO) throws UserIDNotFoundException, ExistsEmailException, ConfirmPasswordException {
		var user = userRepository.findById(userDTO.getId())
				.orElseThrow(() -> new UserIDNotFoundException("El id " + userDTO + " no existe." ));
		this.userUpdateValidation(userDTO, user);
		
		userRepository.save(modelMapper.map(userDTO, User.class));
	}

	@Override
	public void deleteUser(Long id){
		var user = userRepository.findById(id).orElseThrow();

		if(user.isEnabled()){
			user.setEnabled(false);
			userRepository.save(user);
		}
	}
	
	
	public void userValidation(UserDtoReq userDTO) throws ExistsEmailException, ConfirmPasswordException {

		if(userRepository.existsByEmail(userDTO.getEmail())) {
			throw new ExistsEmailException("El email ya se encuentra registrado");
		}
		if(!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
			throw new ConfirmPasswordException("Los campos password y confirmar password deben coincidir");
		}
	}
	
	public void userUpdateValidation(UserDtoReq userDTO, User user) throws ExistsEmailException, ConfirmPasswordException, UserIDNotFoundException {
		if(userRepository.existsByEmail(userDTO.getEmail()) && !userDTO.getEmail().equals(user.getEmail()) ) {
			throw new ExistsEmailException("El email ya se encuentra registrado");
		}
		if(!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
			throw new ConfirmPasswordException("Los campos password y confirmar password deben coincidir");
		}
	}
	
	
	

}
