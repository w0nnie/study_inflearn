package hello.itemservice.domain.item;

import lombok.Data;

@Data
public class UpdateItem {

    private String itemName;
    private Integer price;
    private Integer quantity;

    public UpdateItem(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
