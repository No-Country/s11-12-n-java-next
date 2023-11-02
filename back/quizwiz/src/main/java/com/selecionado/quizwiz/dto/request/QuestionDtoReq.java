package com.selecionado.quizwiz.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDtoReq {

    private Long id;
    @NotNull(message = "no puede estar vacio")
    private String question;
    private FormDtoReq form;
}
