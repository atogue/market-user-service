package org.craftchain.market.user.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.craftchain.market.user.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    private User user;
    private Order order;
    private Payment payment;
}
