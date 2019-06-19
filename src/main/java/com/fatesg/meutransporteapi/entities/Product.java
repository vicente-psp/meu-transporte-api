package com.fatesg.meutransporteapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_product")
@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", initialValue = 1, allocationSize = 1)
public class Product extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @Column(name = "id")
    private Long idProduct;

    @NotBlank(message = "Descrição é obrigatório")
    @Size(min = 3, message = "Descrição deve ter de 3 a 200 caracteres")
    @Column(length = 200, nullable = false)
    private String description;

    @NotNull(message = "Valor é obrigatório")
    @Column(name = "social_name", nullable = false)
    private Double value;

    @Column(name = "initial_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date initialDate;

    @Column(name = "final_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalDate;
    
}
