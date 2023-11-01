package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.TeamDtoReq;
import com.selecionado.quizwiz.dto.response.MemberFormDtoRes;
import com.selecionado.quizwiz.dto.response.TeamDTORes;
import com.selecionado.quizwiz.exceptions.FormNotFoundException;

import java.util.List;

public interface ITeamService {
    List<TeamDTORes> getAllTeams();
    TeamDTORes getTeamById(Long id);
    MemberFormDtoRes create(TeamDtoReq teamDtoReq) throws FormNotFoundException;
    TeamDTORes update(Long id, TeamDtoReq teamDtoReq);
    void deleteById(Long id);
}
