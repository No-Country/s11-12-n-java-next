package com.selecionado.quizwiz.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnsweredFormDtoReq {

    private Long id;
    private FormDtoReq form;
    private UserDtoReq user;

}
