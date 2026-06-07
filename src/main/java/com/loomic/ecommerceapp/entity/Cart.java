package com.loomic.ecommerceapp.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "m_carts")
@Getter
@Setter
public class Cart extends BaseClass{

    @Id
    @Column(name = "cart_pid")
    private Long cartId;

    @Enumerated(EnumType.STRING)
    @Column(name = "cart_status", nullable = false)
    private CartStatus cartStatus;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cart_products",
            joinColumns = @JoinColumn(name = "cart_xid", referencedColumnName = "cart_pid"),
            inverseJoinColumns = @JoinColumn(name = "product_xid", referencedColumnName = "product_pid")
    )
    private Set<Product> products = new HashSet<>();

}
