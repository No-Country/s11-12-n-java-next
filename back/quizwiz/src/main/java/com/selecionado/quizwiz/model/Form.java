package com.selecionado.quizwiz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "forms")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "idCreator")
    @JsonIgnoreProperties("createdForms")
    private User creator;
    @OneToMany(mappedBy = "form")
    @JsonIgnoreProperties("form")
    private List<Question> questions;
    @OneToMany(mappedBy = "form")
    private List<Team> teams;
}
