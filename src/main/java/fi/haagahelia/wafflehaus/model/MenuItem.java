package fi.haagahelia.wafflehaus.model;

import jakarta.persistence.*;

/**
 * Represents a single menu item in the WaffleHaus system.
 * Contains details like name, description, price, category, and image URL.
 * Mapped to the database as a JPA entity.
 */

@Entity
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private String category;
    private String imageURL;

    public MenuItem() {}

    //constructor allows seeding without manually passing ID
    public MenuItem(String name, String description, double price, String category, String imageURL) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageURL = imageURL;
    }

    public MenuItem(Long id, String name, String description, double price, String category, String imageURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageURL = imageURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
