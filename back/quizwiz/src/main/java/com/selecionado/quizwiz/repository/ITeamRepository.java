package com.selecionado.quizwiz.repository;

import com.selecionado.quizwiz.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Long> {
}
