package com.selecionado.quizwiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selecionado.quizwiz.dto.request.UserDtoReq;
import com.selecionado.quizwiz.dto.response.UserDTORes;
import com.selecionado.quizwiz.exceptions.ConfirmPasswordException;
import com.selecionado.quizwiz.exceptions.ExistsEmailException;
import com.selecionado.quizwiz.exceptions.UserIDNotFoundException;
import com.selecionado.quizwiz.service.IUserService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping()
	public ResponseEntity<HttpStatus> saveUser(@RequestBody UserDtoReq userDTO) throws ExistsEmailException, ConfirmPasswordException, UserIDNotFoundException {
		userService.saveUser(userDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTORes> getUserById(@PathVariable Long id) throws UserIDNotFoundException{
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@PutMapping()
	public ResponseEntity<HttpStatus> updateUser(@RequestBody UserDtoReq userDTO) throws UserIDNotFoundException, ExistsEmailException, ConfirmPasswordException{
		userService.updateUser(userDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
