package com.edu.service;

import com.edu.domain.Order;

/**
 * Created by ed on 10/25/15.
 */

public interface OrderService {

    void processOrder(String productId, long count);

    Long saveOrder(Order order);
}
