package com.example.Chapter4.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class OrderProductKey implements Serializable {
    @Column(name = "order_id")
    UUID orderId;

    @Column(name = "product_id")
    UUID productId;
}
