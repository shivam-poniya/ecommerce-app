package com.loomic.ecommerceapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "m_products")
@Getter
@Setter
public class Product extends BaseClass {

    @Id
    @Column(name = "product_pid")
    private Long productId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "price", nullable = false, precision = 15, scale = 2)
    private BigDecimal price;
    @ElementCollection
    @CollectionTable(
            name = "m_product_tags",
            joinColumns = @JoinColumn(name = "product_xid", referencedColumnName = "product_pid")
    )
    @Column(name = "tags")
    private List<String> tags;
}
