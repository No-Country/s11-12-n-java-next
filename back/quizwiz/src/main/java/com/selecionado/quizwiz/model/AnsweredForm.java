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
@Entity
public class AnsweredForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUser")
    @JsonIgnoreProperties("AnsweredForm")
    private User user;

    @OneToOne
    private Form form;

    @OneToMany(mappedBy = "answeredForm")
    @JsonIgnoreProperties("answeredForm")
    private List<Answer> answer;
}
