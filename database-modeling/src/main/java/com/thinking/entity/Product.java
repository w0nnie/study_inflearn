package com.thinking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private int product_number;
    private String product_name;
    private int inventory;
    private int price;
    private String manufacturer;

}
