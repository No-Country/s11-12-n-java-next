package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.DTO.request.UserDtoReq;
import com.selecionado.quizwiz.model.User;
import com.selecionado.quizwiz.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(UserDtoReq userDtoReq) {
        User user = modelMapper.map(userDtoReq, User.class);
        userRepository.save(user);
        return user;
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User no encontrado"));
    }

    @Override
    public User update(UserDtoReq userDtoReq, Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User no encontrado");
        }
        User userUpdate = modelMapper.map(userDtoReq, User.class);
        return userRepository.save(userUpdate);
    }

    @Override
    public void delete(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User no encontrado");
        }
        userRepository.deleteById(userId);
    }
}
