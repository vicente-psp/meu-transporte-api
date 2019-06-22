package com.fatesg.meutransporteapi.entities;

import com.fatesg.meutransporteapi.utils.enums.CnhCategory;
import com.fatesg.meutransporteapi.utils.enums.Gender;
import org.hibernate.validator.constraints.br.CPF;
import java.util.Date;
import javax.validation.constraints.*;
import javax.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")
@Entity(name = "tb_driver")
@SequenceGenerator(name = "driver_seq", sequenceName = "driver_seq", initialValue = 1, allocationSize = 1)
public class Driver extends User {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, message = "Nome deve ter de 3 a 75 caracteres")
    @Column(length = 75, nullable = false)
    private String name;

    @NotNull(message = "CNH é obrigatório")
    @Size(max = 11, message = "CNH deve ter no máximo 11 caracteres")
    @Column(length = 11, nullable = false)
    private String cnh;

    @CPF(message = "CPF inválido")
    @Size(max = 11, message = "CPF deve ter no máximo 11 caracteres")
    @Column(length = 11, nullable = false)
    private String cpf;

    @Size(max = 20, message = "Nome deve ter no máximo 20 caracteres")
    @Column(length = 20)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "cnh_category", nullable = false)
    private CnhCategory cnhCategory;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(name = "first_date_cnh", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date firstDateCnh;

    @Column(name = "validity_of_cnh", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date validityOfCnh;

    @Column(name = "date_of_birth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

}

