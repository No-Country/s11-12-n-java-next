package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.TeamDtoReq;
import com.selecionado.quizwiz.dto.response.TeamDTORes;

import java.util.List;

public interface ITeamService {
    List<TeamDTORes> getAllTeams();
    TeamDTORes getTeamById(Long id);
    TeamDTORes create(TeamDtoReq teamDtoReq);
    TeamDTORes update(Long id, TeamDtoReq teamDtoReq);
    void deleteById(Long id);
}
