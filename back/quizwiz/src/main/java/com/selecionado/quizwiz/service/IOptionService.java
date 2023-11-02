package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.OptionDtoReq;
import com.selecionado.quizwiz.dto.response.OptionDtoRes;
import com.selecionado.quizwiz.model.Option;


import java.util.List;

public interface IOptionService {

    List<Option> findAllOption();
    OptionDtoRes saveOption(OptionDtoReq optionDtoReq);
    Option findByIdOption(Long id);
    OptionDtoRes updateOption(OptionDtoReq optionDtoReq, Long id);
    void deleteOption(Long id);
}
