package com.beapsmarket.webapp.model.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private boolean state;

	@OneToMany(mappedBy = "delivery")
	private Set<ShoppingList> shoppingLists;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

}