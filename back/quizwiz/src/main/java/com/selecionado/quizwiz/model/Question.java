package com.selecionado.quizwiz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;
    private String answer;
    @OneToMany(mappedBy = "question")
    private List<Option> options;
    @ManyToOne
    @JoinColumn(name = "idForm")
    private Form form;

}
