package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.TeamDtoReq;
import com.selecionado.quizwiz.dto.response.MemberFormDtoRes;
import com.selecionado.quizwiz.dto.response.SaveTeamDTORes;
import com.selecionado.quizwiz.dto.response.TeamDtoRes;
import com.selecionado.quizwiz.exceptions.FormNotFoundException;

import java.util.List;

public interface ITeamService {
    List<TeamDtoRes> getAllTeams();
    TeamDtoRes getTeamById(Long id);
    MemberFormDtoRes create(TeamDtoReq teamDtoReq) throws FormNotFoundException;
    SaveTeamDTORes update(Long id, TeamDtoReq teamDtoReq);
    void deleteById(Long id);
}
