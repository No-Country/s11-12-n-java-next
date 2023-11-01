package com.selecionado.quizwiz.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDtoReq {
    @NotNull(message = "no puede estar vacio")
    private String name;
    @NotNull(message = "no puede estar vacio")
    private List<MemberDtoReq> members;
    private FormDtoReq form;
}
