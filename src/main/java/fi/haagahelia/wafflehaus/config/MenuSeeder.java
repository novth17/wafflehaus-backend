package fi.haagahelia.wafflehaus.config;

import fi.haagahelia.wafflehaus.model.MenuCategory;
import fi.haagahelia.wafflehaus.model.MenuItem;
import fi.haagahelia.wafflehaus.repository.MenuItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Seeds the database with delicious Belgian-style waffle items
 * Only runs if the menu is currently empty
 */
@Configuration
public class MenuSeeder implements CommandLineRunner {

    @Autowired
    private MenuItemRepository menuRepo;

    @Override
    public void run(String... args) {
        if (menuRepo.count() == 0) {
            // Core Waffles
            menuRepo.save(new MenuItem(
                    "Royal Strawberry Cream",
                    "A golden Belgian waffle topped with fresh strawberries, vanilla mascarpone cream, and powdered sugar.",
                    7.90,
                    MenuCategory.WAFFLE,
                    "https://wafflehaus.img/royal-strawberry.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Bruges Dark Delight",
                    "A rich cocoa waffle with warm Belgian chocolate sauce, cocoa shavings, and chocolate pearls.",
                    8.50,
                    MenuCategory.WAFFLE,
                    "https://wafflehaus.img/bruges-delight.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Savory Sunrise Waffle",
                    "A crispy Belgian waffle layered with creamy scrambled eggs, smoked ham, melted cheddar, and fresh herbs.",
                    9.20,
                    MenuCategory.WAFFLE,
                    "https://wafflehaus.img/savory-sunrise.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Matcha Velvet",
                    "Soft matcha-infused waffle topped with white chocolate drizzle, juicy raspberries, and a hint of vanilla.",
                    8.30,
                    MenuCategory.WAFFLE,
                    "https://wafflehaus.img/matcha-velvet.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Elegant Vegan Bliss",
                    "A crunchy plant-based waffle topped with maple syrup, caramelized banana slices, and toasted hazelnuts.",
                    7.60,
                    MenuCategory.VEGAN,
                    "https://wafflehaus.img/vegan-bliss.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Caramel Cloud Crunch",
                    "Fluffy waffle with salted caramel drizzle, whipped cream, and honeycomb toffee shards.",
                    7.80,
                    MenuCategory.WAFFLE,
                    "https://wafflehaus.img/caramel-cloud.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Belgian Berry Bash",
                    "Classic Belgian waffle topped with fresh raspberries, blueberries, strawberries, and a hint of mint.",
                    8.00,
                    MenuCategory.WAFFLE,
                    "https://wafflehaus.img/berry-bash.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Crispy Chicken & Maple Gold",
                    "Golden waffle stacked with crispy fried chicken and real maple syrup — the perfect salty-sweet combo.",
                    9.50,
                    MenuCategory.WAFFLE,
                    "https://wafflehaus.img/chicken-maple.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Espresso Hazelnut Hug",
                    "Coffee-infused waffle topped with espresso glaze, toasted hazelnuts, and vanilla bean cream.",
                    8.20,
                    MenuCategory.WAFFLE,
                    "https://wafflehaus.img/espresso-hug.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Truffle Parmesan Stack",
                    "Savory waffle infused with truffle oil, layered with shaved parmesan, and arugula — a gourmet delight.",
                    9.90,
                    MenuCategory.WAFFLE,
                    "https://wafflehaus.img/truffle-stack.jpg"
            ));

            // Drinks
            menuRepo.save(new MenuItem(
                    "Choco-Chai Dream",
                    "Creamy Belgian hot chocolate swirled with chai spices, topped with cinnamon foam and a waffle crisp.",
                    4.80,
                    MenuCategory.DRINK,
                    "https://wafflehaus.img/choco-chai.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Fizzy Lemon Lavender",
                    "Sparkling lemon soda infused with a hint of lavender and served with a sugar rim and edible flower.",
                    4.50,
                    MenuCategory.DRINK,
                    "https://wafflehaus.img/fizzy-lavender.jpg"
            ));

            // Toppings
            menuRepo.save(new MenuItem(
                    "Maple-Bacon Crumble",
                    "Crispy bacon bits glazed with maple syrup — the perfect sweet-savory crunch topper.",
                    1.70,
                    MenuCategory.TOPPING,
                    "https://wafflehaus.img/maple-bacon.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Berry Citrus Swirl",
                    "A vibrant sauce blend of strawberries, raspberries, orange zest, and lime for extra zing.",
                    1.50,
                    MenuCategory.TOPPING,
                    "https://wafflehaus.img/berry-swirl.jpg"
            ));

            // Combos
            menuRepo.save(new MenuItem(
                    "Waffle + Brew Duo",
                    "Choose any sweet waffle with a side of Belgian house coffee or tea.",
                    10.90,
                    MenuCategory.COMBO,
                    "https://wafflehaus.img/waffle-brew.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Savory Waffle Meal",
                    "Pick a savory waffle plus your choice of lemonade or chai and a side of waffle fries.",
                    12.50,
                    MenuCategory.COMBO,
                    "https://wafflehaus.img/savory-meal.jpg"
            ));

            // Sweet Specials
            menuRepo.save(new MenuItem(
                    "Coconut Caramel Snowfall",
                    "Coconut-flaked waffle with dulce de leche drizzle, toasted pecans, and vanilla ice cream.",
                    8.70,
                    MenuCategory.SWEET,
                    "https://wafflehaus.img/coconut-caramel.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Lemon Poppy Glazed Dream",
                    "Soft waffle with tangy lemon glaze, poppy seeds, whipped ricotta, and candied lemon peel.",
                    7.90,
                    MenuCategory.SWEET,
                    "https://wafflehaus.img/lemon-poppy.jpg"
            ));

            // Savory Delights
            menuRepo.save(new MenuItem(
                    "Mediterranean Feta Fold",
                    "Savory waffle filled with sun-dried tomatoes, feta, olives, cucumber ribbons, and tzatziki drizzle.",
                    9.30,
                    MenuCategory.SAVORY,
                    "https://wafflehaus.img/med-feta.jpg"
            ));

            menuRepo.save(new MenuItem(
                    "Smoked Salmon Wafflewich",
                    "Open-faced waffle with herbed cream cheese, smoked salmon, red onion, and dill.",
                    10.20,
                    MenuCategory.SAVORY,
                    "https://wafflehaus.img/salmon-wafflewich.jpg"
            ));

            // Final log message
            System.out.printf("Fancy Belgian-style waffle menu added with %d items across all categories 🧇✨%n", menuRepo.count());

        } else {
            System.out.println("Menu already exists — skipping adding.");
        }
    }
}
