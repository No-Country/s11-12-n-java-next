package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.AuthRequestDtoReq;
import com.selecionado.quizwiz.dto.response.AuthResponseDtoRes;

public interface ILoginService {

    AuthResponseDtoRes authenticate(AuthRequestDtoReq request);
}
