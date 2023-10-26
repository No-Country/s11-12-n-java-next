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
    @ManyToMany
    @JoinTable( name = "forms_users",
    joinColumns = @JoinColumn(name = "idForm"),
    inverseJoinColumns = @JoinColumn(name = "idUser"))
    @JsonIgnoreProperties("responseForms")
    private List<User> members;
    @OneToMany(mappedBy = "form")
    @JsonIgnoreProperties("form")
    private List<Question> questions;

}
