package com.selecionado.quizwiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selecionado.quizwiz.model.Team;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Long> {

}
