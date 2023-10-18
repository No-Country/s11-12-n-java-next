package com.selecionado.quizwiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selecionado.quizwiz.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{

}
