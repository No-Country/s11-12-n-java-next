package com.selecionado.quizwiz.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoReq {

    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;
}
