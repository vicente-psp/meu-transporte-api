package com.fatesg.meutransporteapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity(name = "tb_people")
@SequenceGenerator(name = "people_seq", sequenceName = "people_seq", initialValue = 1, allocationSize = 1)
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "people_seq")
    @Column(name = "id")
    private Long idPessoa;

    @NotBlank(message = "Nome é obrigatório")
    @Column(length = 75, nullable = false)
    private String name;

}
