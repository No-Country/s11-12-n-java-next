package com.selecionado.quizwiz.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDtoRes {

    private Long id;
    private String fullName;
    private String email;
}
