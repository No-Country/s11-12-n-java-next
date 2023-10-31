package com.selecionado.quizwiz.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDtoRes {
    private Long id;
    private String answer;
    private QuestionDtoRes question; //TODO ???
    private Long idAnsweredForm; // ??
}
