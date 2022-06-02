package com.beapsmarket.webapp.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "address")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code", nullable = false, length = 8)
    private String code;

    @Column(name = "quarter", nullable = false, length = 50)
    private String quarter;

    @Column(name = "mark", length = 100)
    private String mark;

    @Column(name = "country", nullable = false, length = 30)
    private String country;

    @ManyToOne(optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private User user;

}