package fi.haagahelia.wafflehaus.controller;

import fi.haagahelia.wafflehaus.dto.OrderRequest;
import fi.haagahelia.wafflehaus.model.Order;
import fi.haagahelia.wafflehaus.model.OrderStatus;
import fi.haagahelia.wafflehaus.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Customer places an order
    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest request, Principal principal) {
        Order order = orderService.placeOrder(request, principal.getName()); // principal.getName() = user’s email
        return ResponseEntity.ok(order);
    }

    // Customer views their own orders
    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/my")
    public ResponseEntity<List<Order>> getMyOrders(Principal principal) {
        return ResponseEntity.ok(orderService.getOrdersByUser(principal.getName()));
    }

    // Admin views all orders
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/status")
    public ResponseEntity<Order> updateStatus(
        @PathVariable Long id,
        @RequestParam OrderStatus status) {
        Order updated = orderService.updateOrderStatus(id, status);
        return ResponseEntity.ok(updated);
    }
}
