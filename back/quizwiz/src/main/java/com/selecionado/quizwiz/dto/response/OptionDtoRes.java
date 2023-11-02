package com.selecionado.quizwiz.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionDtoRes {

    private Long id;
    private String label;
    private boolean isSelected;
}
