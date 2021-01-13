package org.craftchain.market.user.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private Date date;
    private String status;
    private int clientId;
}
