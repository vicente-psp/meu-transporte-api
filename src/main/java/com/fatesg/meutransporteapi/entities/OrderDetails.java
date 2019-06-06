package com.fatesg.meutransporteapi.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tb_order_details")
@SequenceGenerator(name = "order_details_seq", sequenceName = "order_details_seq", initialValue = 1, allocationSize = 1)
public class OrderDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
	@Column(name = "idOrderDetails")
	private long idOrderDetails;

	@OneToMany(mappedBy = "IdProduct")
	private Product idProduct;

	@OneToMany(mappedBy = "idOrder")
	private Order idOrder;

	@Column(length = 75, nullable = false)
	private int quantity;
	 
}
 
