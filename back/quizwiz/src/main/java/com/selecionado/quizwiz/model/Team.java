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
@Entity(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "members_teams",
            joinColumns = @JoinColumn(name = "id_teams"),
            inverseJoinColumns = @JoinColumn(name = "id_member")
    )
    @JsonIgnoreProperties("teams")
    private List<User> members;
    @ManyToOne
    @JoinColumn(name = "idForm")
    @JsonIgnoreProperties("teams")
    private Form form;

}
