package com.selecionado.quizwiz.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveTeamDTORes {
    private Long id;
    private String name;
    private List<MemberDtoRes> members;
}
