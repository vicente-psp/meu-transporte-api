package com.fatesg.meutransporteapi.entities;

import java.util.Date;
import javax.validation.constraints.*;
import javax.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")
@Entity(name = "tb_client")
@SequenceGenerator(name = "client_seq", sequenceName = "client_seq", initialValue = 1, allocationSize = 1)
public class Client extends User {

    @NotBlank(message = "Razão social é obrigatório")
    @Size(min = 3, message = "Razão social deve ter de 3 a 150 caracteres")
    @Column(name = "social_name", length = 150, nullable = false)
    private String socialName;

    @Size(max = 75, message = "Nome fantasia deve ter no máximo 75 caracteres")
    @Column(name = "name_fantasy", length = 75)
    private String nameFantasy;

    @NotNull(message = "CNPJ é obrigatório")
    @Size(max = 14, message = "CNPJ deve ter no máximo 14 caracteres")
    @Column(length = 14, nullable = false)
    private String cnpj;

    @Size(max = 20, message = "Nome deve ter no máximo 20 caracteres")
    @Column(length = 20)
    private String phone;

    @Column(name = "initial_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date initialDate;

    @Column(name = "final_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalDate;
    
}
