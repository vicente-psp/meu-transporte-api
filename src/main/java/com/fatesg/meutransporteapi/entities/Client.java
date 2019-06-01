package com.fatesg.meutransporteapi.entities;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tb_client")
@SequenceGenerator(name = "client_seq", sequenceName = "client_seq", initialValue = 1, allocationSize = 1)
public class Client extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
	@Column(name = "id")
	private long id ;

	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres")
	@Column(length = 75, nullable = false)
	private String name;

	@CPF(message = "CNPJ inválido")
	@Column(length = 13, nullable = false)
	private String cnpj;

	@NotBlank(message = "Razão Social é obrigatório")
	@Size(min = 3, message = "Razão Social deve ter no mínimo 3 caracteres")
	@Column(length = 75, nullable = false)
	private String socialName;

	@OneToMany(mappedBy = "idClient")
	private List<Order> orders;
}
 