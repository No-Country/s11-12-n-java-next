package com.selecionado.quizwiz.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDtoReq {
    private Long id;
    private String answer;
    private Long idQuestion;
    private Long idAnsweredForm;
}
