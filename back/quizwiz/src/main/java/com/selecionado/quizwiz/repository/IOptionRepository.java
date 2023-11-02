package com.selecionado.quizwiz.repository;

import com.selecionado.quizwiz.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOptionRepository extends JpaRepository<Option, Long> {

}
