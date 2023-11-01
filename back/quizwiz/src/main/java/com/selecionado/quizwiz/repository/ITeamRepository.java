package com.selecionado.quizwiz.repository;

import com.selecionado.quizwiz.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByName();
}
