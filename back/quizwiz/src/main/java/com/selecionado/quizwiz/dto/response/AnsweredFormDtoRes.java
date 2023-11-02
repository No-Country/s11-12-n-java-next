package com.selecionado.quizwiz.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnsweredFormDtoRes {

    private Long id;
    private UserDTORes user;
    private List<AnswerDtoRes> answers;
    @JsonIgnoreProperties("members")
    private FormDtoRes form;

}
