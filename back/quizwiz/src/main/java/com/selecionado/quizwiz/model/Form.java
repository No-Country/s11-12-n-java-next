package com.selecionado.quizwiz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "idCreator")
    private User creator;
    @ManyToMany
    @JoinTable( name = "forms_users",
    joinColumns = @JoinColumn(name = "idForm"),
    inverseJoinColumns = @JoinColumn(name = "idUser"))
    private List<User> members;
    @OneToMany(mappedBy = "form")
    private List<Question> questions;

}
