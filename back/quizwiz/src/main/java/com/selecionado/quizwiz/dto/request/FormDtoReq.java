package com.selecionado.quizwiz.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormDtoReq {

    private Long id;
    private String title;
    private String description;
    private UserDtoReq creator;
}
