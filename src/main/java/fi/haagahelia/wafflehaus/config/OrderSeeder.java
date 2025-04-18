package fi.haagahelia.wafflehaus.config;

import fi.haagahelia.wafflehaus.model.*;
import fi.haagahelia.wafflehaus.repository.MenuItemRepository;
import fi.haagahelia.wafflehaus.repository.OrderRepository;
import fi.haagahelia.wafflehaus.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Configuration
public class OrderSeeder implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private MenuItemRepository menuRepo;

    @Override
    public void run(String... args) {
        if (orderRepo.count() == 2) {
            User customer = userRepo.findByEmail("honey@waffle.com").orElse(null);
            if (customer == null) {
                System.out.println("⚠️ No customer with email 'taro@waffle.com' found. Skipping order seeding.");
                return;
            }

            MenuItem waffle = menuRepo.findById(77L).orElse(null);
            MenuItem savory = menuRepo.findById(92L).orElse(null);            

            if (waffle == null || savory == null) {
                System.out.println("⚠️ Required menu items not found. Skipping order seeding.");
                return;
            }

            // 🧇 Order 1
            Order order1 = new Order();
            order1.setCustomer(customer);
            order1.setCreatedAt(LocalDateTime.now());
            order1.setStatus(OrderStatus.RECEIVED);

            OrderItem item1 = new OrderItem();
            item1.setOrder(order1);
            item1.setMenuItem(waffle);
            item1.setQuantity(2);
            item1.setPriceAtOrderTime(waffle.getPrice());

            order1.setItems(List.of(item1));
            order1.setTotalPrice(item1.getQuantity() * item1.getPriceAtOrderTime());

            // 🧂 Order 2
            Order order2 = new Order();
            order2.setCustomer(customer);
            order2.setCreatedAt(LocalDateTime.now().minusHours(1));
            order2.setStatus(OrderStatus.PREPARING);
            order2.setNote("No onions, please.");

            OrderItem item2 = new OrderItem();
            item2.setOrder(order2);
            item2.setMenuItem(savory);
            item2.setQuantity(1);
            item2.setPriceAtOrderTime(savory.getPrice());

            order2.setItems(List.of(item2));
            order2.setTotalPrice(item2.getQuantity() * item2.getPriceAtOrderTime());

            // 💾 Save both orders
            orderRepo.saveAll(Arrays.asList(order1, order2));

            System.out.println("✅ Seeded 2 sample orders linked to 'customer@wafflehaus.com'.");
        } else {
            System.out.println("🛑 Orders already exist — skipping order seeding.");
        }
    }
}
