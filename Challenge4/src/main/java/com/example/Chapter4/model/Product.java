package com.example.Chapter4.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(targetEntity = Merchant.class)
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    //===Column=====
    private String name;
    private int price;
    private LocalDateTime createdDate;
    private LocalDateTime deletedDate;
    //===Column=====

    public Product(String name) {
        this.name = name;
    }
}
