package com.selecionado.quizwiz.controller;

import com.selecionado.quizwiz.dto.request.AuthRequestDtoReq;
import com.selecionado.quizwiz.dto.response.AuthResponseDtoRes;
import com.selecionado.quizwiz.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private ILoginService loginService;

    /**
     * Metodo de logueo de usuario por email y contraseña, devuelve respuesta http con el token JWT
     * @param authDTO dto con email y contraseña de usuario
     * @return respuesta http con token jwt
     */
//    @Operation(
//            summary = "Login de usuario",
//            description = "Logueo de usuario por email y contraseña, y devuelve una respuesta http con un token JWT")
    @PostMapping("api/v1/login")
    public ResponseEntity<AuthResponseDtoRes> login(@RequestBody AuthRequestDtoReq authDTO){
        return ResponseEntity.ok(loginService.authenticate(authDTO));
    }
}
