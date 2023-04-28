package entity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Order {
    private String category;
    private String type;
    private String name;
    private String quantity;

    public Order(String category, String type, String name, String quantity) {
        this.category = category;
        this.type = type;
        this.name = name;
        this.quantity = quantity;
    }
}
