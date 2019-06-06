package com.fatesg.meutransporteapi.entities;

import lombok.*;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity(name = "tb_address")
@SequenceGenerator(name = "address_seq", sequenceName = "address_seq", initialValue = 1, allocationSize = 1)
public class Address extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
	@Column(name = "idAddress")
	private Long idAddress;

	@NotBlank(message = "CEP é obrigatório")
	@Column(length = 8, nullable = false)
	private String cep;

	@NotBlank(message = "Descrição da rua e endereço é obrigatório")
	@Size(min = 3, message = "Descrição deve ter no mínimo 3 caracteres")
	@Column(length = 75, nullable = false)
	private String description;

	@NumberFormat
	@Column(length = 13, nullable = false)
	private String number;

	@Column(length = 13, nullable = false)
	private String lat;

	@Column(length = 13, nullable = false)
	private String longitude;

	@Column(name = "initial_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date initialDate;

	@Column(name = "final_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date finalDate;

}
 
