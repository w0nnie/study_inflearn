package hello.login.domain.item;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Item {

    @NotEmpty
    private Long id;
    @NotEmpty
    private String itemName;
    @NotEmpty
    private Integer price;
    @NotEmpty
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}