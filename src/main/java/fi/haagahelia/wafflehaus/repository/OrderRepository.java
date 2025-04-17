package fi.haagahelia.wafflehaus.repository;

import fi.haagahelia.wafflehaus.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// find orders placed by a specific user
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerEmail(String email);
}
