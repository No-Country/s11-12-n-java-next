package com.selecionado.quizwiz.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDtoRes {
    private String token;
    private String email;
    private String fullname;
}
