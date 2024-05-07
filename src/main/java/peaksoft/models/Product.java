package peaksoft.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Product {
    private Long id;
    private String name;
    private String rating;
    private int price;

    public Product(String name, String rating, int price) {
        this.name = name;
        this.rating = rating;
        this.price = price;
    }
}
