package com.selecionado.quizwiz.repository;

import com.selecionado.quizwiz.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer, Long> {

}
