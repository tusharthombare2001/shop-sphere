package ecommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	List<Order> findByCustomerId(Long customerId);
}
