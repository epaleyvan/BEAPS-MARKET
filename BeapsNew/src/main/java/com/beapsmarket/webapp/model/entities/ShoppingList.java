package com.beapsmarket.webapp.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "shopping_list", indexes = {
        @Index(name = "reference", columnList = "reference", unique = true)
})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "reference", nullable = false, length = 15)
    private String reference;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idpayment", nullable = false)
    private Payment payment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "iddelivery", nullable = false)
    private Delivery delivery;

    @ManyToOne(optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private User user;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "product_shopping_list",
            joinColumns = {@JoinColumn(name = "idshoppinglist")},
            inverseJoinColumns = {@JoinColumn(name = "idproduct")}
    )
    private Set<Product> products = new HashSet<Product>();
}