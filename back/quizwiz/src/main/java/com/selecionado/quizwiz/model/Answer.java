package com.selecionado.quizwiz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answer;
    private Long idUserRes; //TODO ????
    private boolean isSelected;
    @OneToOne
    private Question question;
    @ManyToOne
    @JoinColumn(name = "idAnsweredForm")
    @JsonIgnoreProperties("answer")
    private AnsweredForm answeredForm;
}
