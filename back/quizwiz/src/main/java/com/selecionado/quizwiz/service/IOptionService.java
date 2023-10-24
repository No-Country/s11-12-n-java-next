package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.OptionDtoReq;
import com.selecionado.quizwiz.model.Option;


import java.util.List;

public interface IOptionService {

    List<Option> findAllOption();
    Option saveOption(OptionDtoReq optionDtoReq);
    Option findByIdOption(Long id);
    Option updateOption(OptionDtoReq optionDtoReq, Long id);
    void deleteOption(Long id);
}
