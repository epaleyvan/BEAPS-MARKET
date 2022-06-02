package com.beapsmarket.webapp.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "delivery", indexes = {
        @Index(name = "reference", columnList = "reference", unique = true)
})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "reference", nullable = false, length = 15)
    private String reference;

    @Column(name = "state", nullable = false)
    private Boolean state = false;

    @ManyToOne(optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private User user;

}