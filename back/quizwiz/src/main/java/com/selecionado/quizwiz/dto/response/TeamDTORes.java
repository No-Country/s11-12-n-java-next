package com.selecionado.quizwiz.dto.response;

import com.selecionado.quizwiz.dto.request.FormDtoReq;
import com.selecionado.quizwiz.dto.request.MemberDtoReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTORes {
    private Long id;
    private String name;
    private List<MemberDtoReq> members;
    private FormDtoReq form;
}
