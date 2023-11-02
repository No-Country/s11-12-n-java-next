package com.selecionado.quizwiz.repository;

import com.selecionado.quizwiz.model.AnsweredForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnsweredFormRepository extends JpaRepository<AnsweredForm, Long> {
}
