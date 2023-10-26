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
@Entity(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String answer;
    @OneToMany(mappedBy = "question")
    @JsonIgnoreProperties("question")
    private List<Option> options;
    @ManyToOne
    @JoinColumn(name = "idForm")
    @JsonIgnoreProperties("questions")
    private Form form;

}
