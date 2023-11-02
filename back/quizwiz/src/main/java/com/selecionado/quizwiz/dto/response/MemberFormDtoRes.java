package com.selecionado.quizwiz.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberFormDtoRes {

    private Long id;
    private String message;
    private List<String> emails;
}
