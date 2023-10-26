package com.selecionado.quizwiz.dto.response;

import com.selecionado.quizwiz.model.Option;
import com.selecionado.quizwiz.model.Question;
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
    private List<Question> questions;
    private List<UserDTORes> members;

}
