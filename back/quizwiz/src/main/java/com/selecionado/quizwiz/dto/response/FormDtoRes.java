package com.selecionado.quizwiz.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormDtoRes {

    private Long id;
    private String title;
    private String description;
    private List<QuestionDtoRes> questions;
    private List<TeamDtoRes> teams;

}
