package com.fatesg.meutransporteapi.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")
@Entity(name = "tb_client")
@SequenceGenerator(name = "client_seq", sequenceName = "client_seq", initialValue = 1, allocationSize = 1)
public class Client extends User {

    @NotBlank(message = "Razão social é obrigatório")
    @Size(min = 3, message = "Razão social deve ter no mínimo 3 caracteres")
    @Column(name = "social_name", length = 150, nullable = false)
    private String socialName;

    @Column(name = "name_fantasy", length = 75)
    private String nameFantasy;
    
}
