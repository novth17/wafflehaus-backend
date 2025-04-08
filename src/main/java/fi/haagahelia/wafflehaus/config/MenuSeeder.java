package fi.haagahelia.wafflehaus.config;

import fi.haagahelia.wafflehaus.model.MenuItem;
import fi.haagahelia.wafflehaus.repository.MenuItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Seeds the database with elegant and delicious Belgian-style waffle items.
 * Only runs if the menu is currently empty.
 */
@Configuration
public class MenuSeeder implements CommandLineRunner {

    @Autowired
    private MenuItemRepository menuRepo;

    @Override
    public void run(String... args) {
        if (menuRepo.count() == 0) {
            // Original 5 items
            menuRepo.save(new MenuItem(
                    "Royal Strawberry Cream",
                    "A golden Belgian waffle topped with fresh strawberries, vanilla mascarpone cream, and powdered sugar.",
                    7.90,
                    "sweet",
                    "https://wafflehaus.img/royal-strawberry.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Bruges Dark Delight",
                    "A rich cocoa waffle with warm Belgian chocolate sauce, cocoa shavings, and chocolate pearls.",
                    8.50,
                    "sweet",
                    "https://wafflehaus.img/bruges-delight.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Savory Sunrise Waffle",
                    "A crispy Belgian waffle layered with creamy scrambled eggs, smoked ham, melted cheddar, and fresh herbs.",
                    9.20,
                    "savory",
                    "https://wafflehaus.img/savory-sunrise.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Matcha Velvet",
                    "Soft matcha-infused waffle topped with white chocolate drizzle, juicy raspberries, and a hint of vanilla.",
                    8.30,
                    "sweet",
                    "https://wafflehaus.img/matcha-velvet.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Elegant Vegan Bliss",
                    "A crunchy plant-based waffle topped with maple syrup, caramelized banana slices, and toasted hazelnuts.",
                    7.60,
                    "vegan",
                    "https://wafflehaus.img/vegan-bliss.jpg"
            ));

            // 5 new fancy items
            menuRepo.save(new MenuItem(
                    "Caramel Cloud Crunch",
                    "Fluffy waffle with salted caramel drizzle, whipped cream, and honeycomb toffee shards.",
                    7.80,
                    "sweet",
                    "https://wafflehaus.img/caramel-cloud.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Belgian Berry Bash",
                    "Classic Belgian waffle topped with fresh raspberries, blueberries, strawberries, and a hint of mint.",
                    8.00,
                    "sweet",
                    "https://wafflehaus.img/berry-bash.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Crispy Chicken & Maple Gold",
                    "Golden waffle stacked with crispy fried chicken and real maple syrup — the perfect salty-sweet combo.",
                    9.50,
                    "savory",
                    "https://wafflehaus.img/chicken-maple.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Espresso Hazelnut Hug",
                    "Coffee-infused waffle topped with espresso glaze, toasted hazelnuts, and vanilla bean cream.",
                    8.20,
                    "sweet",
                    "https://wafflehaus.img/espresso-hug.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Truffle Parmesan Stack",
                    "Savory waffle infused with truffle oil, layered with shaved parmesan, and arugula — a gourmet delight.",
                    9.90,
                    "savory",
                    "https://wafflehaus.img/truffle-stack.jpg"
            ));

            System.out.println("Fancy Belgian-style waffle menu added with 10 items 🧇✨");
        } else {
            System.out.println("Menu already exists — skipping adding.");
        }
    }
}
