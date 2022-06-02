package com.beapsmarket.webapp.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "image", indexes = {
        @Index(name = "reference", columnList = "reference", unique = true),
        @Index(name = "url", columnList = "url", unique = true)
})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "reference", nullable = false, length = 15)
    private String reference;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "url", nullable = false, length = 100)
    private String url;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idproduct", nullable = false)
    private Product product;

}