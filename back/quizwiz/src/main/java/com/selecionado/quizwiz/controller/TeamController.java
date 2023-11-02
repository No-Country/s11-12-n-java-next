package com.selecionado.quizwiz.controller;

import com.selecionado.quizwiz.dto.request.TeamDtoReq;
import com.selecionado.quizwiz.dto.response.MemberFormDtoRes;
import com.selecionado.quizwiz.dto.response.TeamDTORes;
import com.selecionado.quizwiz.service.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipos")
public class TeamController {
    @Autowired
    private TeamServiceImpl teamService;

    @GetMapping()
    public ResponseEntity<List<TeamDTORes>> getAll() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TeamDTORes> getById(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }
    @PostMapping()
    public ResponseEntity<MemberFormDtoRes> create(@RequestBody TeamDtoReq teamDtoReq) {
        return new ResponseEntity<>(teamService.create(teamDtoReq), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TeamDTORes> update(@PathVariable Long id, @RequestBody TeamDtoReq teamDtoReq) {
        return new ResponseEntity<>(teamService.update(id, teamDtoReq), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        teamService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
