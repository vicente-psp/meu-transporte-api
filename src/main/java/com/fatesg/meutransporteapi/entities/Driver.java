package com.fatesg.meutransporteapi.entities;

import com.fatesg.meutransporteapi.utils.enums.CnhCategory;
import com.fatesg.meutransporteapi.utils.enums.Gender;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity(name = "tb_driver")
@SequenceGenerator(name = "driver_seq", sequenceName = "driver_seq", initialValue = 1, allocationSize = 1)
public class Driver extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_seq")
    @Column(name = "id")
    private Long idDriver;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres")
    @Column(length = 75, nullable = false)
    private String name;

    @NotNull(message = "CNH é obrigatório")
    @Column(length = 11, nullable = false)
    private String cnh;

    @CPF(message = "CPF inválido")
    @Column(length = 11, nullable = false)
    private String cpf;

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

    @Column(name = "initial_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date initialDate;

    @Column(name = "final_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalDate;
}
