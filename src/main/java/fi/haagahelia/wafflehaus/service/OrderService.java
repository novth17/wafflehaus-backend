package fi.haagahelia.wafflehaus.service;

import fi.haagahelia.wafflehaus.dto.OrderRequest;
import fi.haagahelia.wafflehaus.model.*;
import fi.haagahelia.wafflehaus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private MenuItemRepository menuItemRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private UserRepository userRepo;

    public Order placeOrder(OrderRequest request, String userEmail) {
        // 1. Find the customer (based on JWT email)
        User customer = userRepo.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 2. Create new Order entity
        Order order = new Order();
        order.setCustomer(customer);
        order.setNote(request.getNote());

        // 3. Prepare list of order items
        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;

        for (OrderRequest.Item reqItem : request.getItems()) {
            MenuItem menuItem = menuItemRepo.findById(reqItem.getMenuItemId())
                    .orElseThrow(() -> new RuntimeException("Menu item not found: " + reqItem.getMenuItemId()));

            OrderItem item = new OrderItem();
            item.setMenuItem(menuItem);
            item.setQuantity(reqItem.getQuantity());
            item.setPriceAtOrderTime(menuItem.getPrice());
            item.setOrder(order); // set the parent order

            total += menuItem.getPrice() * reqItem.getQuantity();
            orderItems.add(item);
        }

        // 4. Attach items & total price to the order
        order.setItems(orderItems);
        order.setTotalPrice(total);

        // 5. Save order (cascades save orderItems)
        return orderRepo.save(order);
    }
    public List<Order> getOrdersByUser(String email) {
        return orderRepo.findByCustomerEmail(email);
    }
    
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = orderRepo.findById(orderId)
            .orElseThrow(() -> new RuntimeException("Order not found"));
        
        order.setStatus(status);
        return orderRepo.save(order);
    }
    
}

