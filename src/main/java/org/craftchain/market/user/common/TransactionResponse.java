package org.craftchain.market.user.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.craftchain.market.user.entity.User;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private User user;
    private Order order;
    private double amount;
    private Date paymentDate;
    private String transactionId;
    private String message;
}
