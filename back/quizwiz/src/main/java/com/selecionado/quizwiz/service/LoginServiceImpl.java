package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.AuthRequestDtoReq;
import com.selecionado.quizwiz.dto.response.AuthResponseDtoRes;
import com.selecionado.quizwiz.repository.IUserRepository;
import com.selecionado.quizwiz.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService{

    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IUserRepository userRepository;

    /**
     * Autentica al usuario y devuelve un token
     * @param request dto de autenticacion
     * @return dto de respuesta de autenticacion
     */
    @Override
    public AuthResponseDtoRes authenticate(AuthRequestDtoReq request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getUsername()).orElseThrow();
        var token = jwtUtils.generateToken(user);
        return new AuthResponseDtoRes(token);
    }
}
