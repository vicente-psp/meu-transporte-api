package com.fatesg.meutransporteapi.entities;


import lombok.*;
import org.springframework.format.annotation.NumberFormat;
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
@Entity(name = "tb_product")
@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", initialValue = 1, allocationSize = 1)
public class Product  extends ResourceSupport implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@Column(name = "idProduct")
	private Long idProduct;

	@NotBlank(message = "Descrição é obrigatório")
	@Size(min = 3, message = "Descrição deve ter no mínimo 3 caracteres")
	@Column(length = 75, nullable = false)
	private String description;

	@NotBlank(message = "Valor é obrigatório")
	@Column(length = 6, nullable = false)
	@NumberFormat
	private Double value;

	@OneToMany(mappedBy = "idOrder")
	private Order idOrder;

	@OneToMany(mappedBy = "idOrderDetails")
	private OrderDetails orderDetails;

	@Column(name = "initial_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date initialDate;

	@Column(name = "final_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date finalDate;
	 
}
 
