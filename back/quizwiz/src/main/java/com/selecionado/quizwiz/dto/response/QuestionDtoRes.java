package com.selecionado.quizwiz.dto.response;

import com.selecionado.quizwiz.dto.request.FormDtoReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDtoRes {

    private Long id;
    private String question;
    private List<OptionDtoRes> options;
}
