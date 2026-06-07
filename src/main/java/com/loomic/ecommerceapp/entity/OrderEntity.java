package com.loomic.ecommerceapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "m_orders",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "cart_xid")})
public class OrderEntity extends BaseClass {
    @Id
    @Column(name = "order_pid")
    private Long orderId;
    @Column(name = "transaction_pid", nullable = false, unique = true)
    private String transactionId;
    @Column(name = "cart_xid", nullable = false)
    private Long cartId;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_xid", referencedColumnName = "order_pid"),
            inverseJoinColumns = @JoinColumn(name = "product_xid", referencedColumnName = "product_pid"))
    private Set<Product> products = new HashSet<>();
}
