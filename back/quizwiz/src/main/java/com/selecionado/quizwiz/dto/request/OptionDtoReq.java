package com.selecionado.quizwiz.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionDtoReq {
    private Long id;
    @NotNull(message = "no puede estar vacio")
    private String label;
    private QuestionDtoReq question;
}
