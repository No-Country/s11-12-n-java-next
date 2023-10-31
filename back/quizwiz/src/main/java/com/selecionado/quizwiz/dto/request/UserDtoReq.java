package com.selecionado.quizwiz.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoReq {

    private Long id;
    @NotNull(message = "no puede estar vacio")
    private String fullName;
    @Email(message = "debe contener un formato de tipo email")
    private String email;
    @NotNull(message = "no puede estar vacio")
    private String password;
    @NotNull(message = "no puede estar vacio")
    private String confirmPassword;
}
