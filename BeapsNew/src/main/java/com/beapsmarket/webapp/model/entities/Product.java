package com.beapsmarket.webapp.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Table(name = "product", indexes = {
        @Index(name = "reference", columnList = "reference", unique = true)
})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "reference", nullable = false, length = 15)
    private String reference;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "unitprice", nullable = false)
    private Double unitprice;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity_list")
    private Integer quantityList;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idcategory", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<Image> images = new TreeSet<Image>();

    @ManyToMany(mappedBy = "products")
    private Set<ShoppingList> shoppingLists = new HashSet<ShoppingList>();

}