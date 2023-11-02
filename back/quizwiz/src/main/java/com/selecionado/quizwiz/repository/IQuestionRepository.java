package com.selecionado.quizwiz.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.selecionado.quizwiz.model.Question;

public interface IQuestionRepository extends JpaRepository<Question, Long>{

}
