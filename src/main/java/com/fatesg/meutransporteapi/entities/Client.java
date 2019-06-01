package com.fatesg.meutransporteapi.entities;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tb_client")
@SequenceGenerator(name = "client_seq", sequenceName = "client_seq", initialValue = 1, allocationSize = 1)
public class Client {

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
	 
	private List<Order> orders;

	@OneToMany
	private Order idOrder;
	 
}
 
