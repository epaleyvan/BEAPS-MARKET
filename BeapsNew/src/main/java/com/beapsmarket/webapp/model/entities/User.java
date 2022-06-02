package com.beapsmarket.webapp.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "user", indexes = {
        @Index(name = "email", columnList = "email", unique = true),
        @Index(name = "username", columnList = "username", unique = true)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "gender", nullable = false, length = 6)
    private String gender;

    @Column(name = "phone", nullable = false)
    private Integer phone;

    @Column(name = "type", nullable = false, length = 15)
    private String type;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Column(name = "password", nullable = false, length = 30)
    private String password;


    @OneToMany(mappedBy = "user")
    private Set<Address> addresses = new HashSet<Address>();

    @OneToMany(mappedBy = "user")
    private Set<ShoppingList> shoppingLists = new HashSet<ShoppingList>();

    @OneToMany(mappedBy = "user")
    private Set<Delivery> deliveries = new HashSet<Delivery>();

    @OneToMany(mappedBy = "user")
    private Set<Payment> payments = new HashSet<Payment>();

}