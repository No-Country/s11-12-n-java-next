package com.selecionado.quizwiz.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDtoReq {

    private Long id;
    private String name;
    private List<MemberDtoReq> members;
    private FormDtoReq form;

}
