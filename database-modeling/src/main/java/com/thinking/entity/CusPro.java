package com.thinking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CusPro {
    private int order_number;
    private String customer_id;
    private int product_number;
    private int quantity;
    private Date order_date;
}
