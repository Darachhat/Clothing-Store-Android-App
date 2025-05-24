package mobileappdevelopmet.homework_3.model;

import java.io.Serializable;

public class Product  implements Serializable {
    private int id;
    private String name;
    private String image;
    private double price;
    private double rating;
    private String description;
    public Product(String name, String image, double price, double rating, String description) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.rating = rating;
        this.description = description;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getImage() { return image; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }
    public String getDescription() { return description; }
}
