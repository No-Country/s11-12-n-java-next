package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.MemberDtoReq;
import com.selecionado.quizwiz.dto.request.TeamDtoReq;
import com.selecionado.quizwiz.dto.response.MemberFormDtoRes;
import com.selecionado.quizwiz.dto.response.SaveTeamDTORes;
import com.selecionado.quizwiz.dto.response.TeamDtoRes;
import com.selecionado.quizwiz.exceptions.TeamNameExistsException;
import com.selecionado.quizwiz.exceptions.TeamNotFoundException;
import com.selecionado.quizwiz.model.Team;
import com.selecionado.quizwiz.model.User;
import com.selecionado.quizwiz.repository.ITeamRepository;
import com.selecionado.quizwiz.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements ITeamService{
    @Autowired
    private ITeamRepository teamRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<TeamDtoRes> getAllTeams() {
        return teamRepository.findAll().stream().map(team -> modelMapper.map(team, TeamDtoRes.class)).collect(Collectors.toList());
    }

    @Override
    public TeamDtoRes getTeamById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException("El equipo con id " + id + " no fue encontrado en la base de datos"));
        return modelMapper.map(team, TeamDtoRes.class);
    }

    @Override
    public MemberFormDtoRes create(TeamDtoReq teamDtoReq) {
        if (teamRepository.existsByName(teamDtoReq.getName())) {
        throw new TeamNameExistsException("El equipo con nombre " + teamDtoReq.getName() + " ya existe en base de datos");
        }
        List<String> notEncounteredMails = new ArrayList<>();
        List<User> encounteredUsers = new ArrayList<>();
        for (MemberDtoReq member : teamDtoReq.getMembers()) {
            Optional<User> user = userRepository.findByEmail(member.getEmail());
            if (user.isEmpty()) {
                notEncounteredMails.add(member.getEmail());
            } else {
                encounteredUsers.add(user.get());
            }
        }
        Team team = modelMapper.map(teamDtoReq, Team.class);
        team.setMembers(encounteredUsers);
        Team teamDB = teamRepository.save(team);
        MemberFormDtoRes memberFormDtoRes = new MemberFormDtoRes();
        memberFormDtoRes.setId(teamDB.getId());
        if (notEncounteredMails.isEmpty()) {
            memberFormDtoRes.setMessage("El team se guardo correctamente");
            return memberFormDtoRes;
        } else {
            memberFormDtoRes.setMessage("Los siguientes emails no fueron registrados");
            memberFormDtoRes.setEmails(notEncounteredMails);
            return memberFormDtoRes;
        }
    }

    @Override
    public SaveTeamDTORes update(Long id, TeamDtoReq teamDtoReq) {
        teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException("El equipo con id " + id + " no fue encontrado en la base de datos"));
        Team teamRequest = modelMapper.map(teamDtoReq, Team.class);
        teamRequest.setId(id);
        Team teamSaved = teamRepository.save(teamRequest);
        return modelMapper.map(teamSaved, SaveTeamDTORes.class);
    }

    @Override
    public void deleteById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException("El equipo con id " + id + " no fue encontrado en la base de datos"));
        teamRepository.delete(team);
    }
}
