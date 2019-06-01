package com.fatesg.meutransporteapi.entities;


import lombok.*;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tb_order")
@SequenceGenerator(name = "order_seq", sequenceName = "order_seq", initialValue = 1, allocationSize = 1)
public class Order extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@Column(name = "id")
	private Long idOrder;

	@Column(length = 75, nullable = false)
	private double value;


	@Column(length = 75, nullable = false)
	private Client idClient;

	@ManyToOne
	@Column(length = 75, nullable = false)
	private Route idRoute;

	@OneToMany
	@Column(length = 75, nullable = false)
	private OrderDetails orderDetails;

	@Column(name = "initial_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date initialDate;

	@Column(name = "final_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date finalDate;
}
 
