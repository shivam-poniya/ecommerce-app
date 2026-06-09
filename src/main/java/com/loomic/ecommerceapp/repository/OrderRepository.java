package com.loomic.ecommerceapp.repository;

import com.loomic.ecommerceapp.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
//    Optional<OrderEntity> findByCartId(Long cartId);
//
//    boolean existsByCartId(Long cartId);
//
//    Optional<OrderEntity> findByTransactionId(String transactionId);

}
