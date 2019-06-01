package com.fatesg.meutransporteapi.entities;


import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tb_order")
@SequenceGenerator(name = "order_seq", sequenceName = "order_seq", initialValue = 1, allocationSize = 1)
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@Column(name = "id")
	private long id;

	@Column(length = 75, nullable = false)
	private double value;


	@Column(length = 75, nullable = false)
	private People idPeople;

	@ManyToOne
	@Column(length = 75, nullable = false)
	private Route idRoute;

	@OneToMany
	@Column(length = 75, nullable = false)
	private OrderDetails orderDetails;
}
 
