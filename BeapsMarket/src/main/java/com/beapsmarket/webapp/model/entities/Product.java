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
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String reference;
	private String name;
	private int unitPrice;
	private String description;
	private int quantityList;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@ManyToMany(mappedBy = "products")
	private Set<ShoppingList> shoppingLists;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<Picture> pictures;

}