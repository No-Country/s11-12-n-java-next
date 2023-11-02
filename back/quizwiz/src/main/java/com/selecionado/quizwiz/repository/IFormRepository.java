package com.selecionado.quizwiz.repository;

import com.selecionado.quizwiz.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormRepository extends JpaRepository<Form, Long> {
}
