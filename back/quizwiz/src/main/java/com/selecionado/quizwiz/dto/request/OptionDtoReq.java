package com.selecionado.quizwiz.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionDtoReq {
    private Long id;
    private String label;
    private Boolean isSelected;
    private QuestionDtoReq question;
}
