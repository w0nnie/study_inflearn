package com.thinking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    private String customer_id;
    private String password;
    private String customer_name;
    private int age;
    private String rating;
    private String occupation;
    private int reserves;

}
