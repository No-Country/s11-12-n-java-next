package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.TeamDtoReq;
import com.selecionado.quizwiz.dto.response.TeamDTORes;
import com.selecionado.quizwiz.exceptions.TeamNameExistsException;
import com.selecionado.quizwiz.exceptions.TeamNotFoundException;
import com.selecionado.quizwiz.model.Team;
import com.selecionado.quizwiz.repository.ITeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements ITeamService{
    @Autowired
    private ITeamRepository teamRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TeamDTORes> getAllTeams() {
        return teamRepository.findAll().stream().map(team -> modelMapper.map(team, TeamDTORes.class)).collect(Collectors.toList());
    }

    @Override
    public TeamDTORes getTeamById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException("El equipo con id " + id + " no fue encontrado en la base de datos"));
        return modelMapper.map(team, TeamDTORes.class);
    }

    @Override
    public TeamDTORes create(TeamDtoReq teamDtoReq) {
        if (teamRepository.existsByName(teamDtoReq.getName())) {
        throw new TeamNameExistsException("El equipo con nombre " + teamDtoReq.getName() + " ya existe en base de datos");
        }
        Team team = teamRepository.save(modelMapper.map(teamDtoReq, Team.class));
        return modelMapper.map(team, TeamDTORes.class);
    }

    @Override
    public TeamDTORes update(Long id, TeamDtoReq teamDtoReq) {
        teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException("El equipo con id " + id + " no fue encontrado en la base de datos"));
        Team teamRequest = modelMapper.map(teamDtoReq, Team.class);
        teamRequest.setId(id);
        Team teamSaved = teamRepository.save(teamRequest);
        return modelMapper.map(teamSaved, TeamDTORes.class);
    }

    @Override
    public void deleteById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException("El equipo con id " + id + " no fue encontrado en la base de datos"));
        teamRepository.delete(team);
    }
}
