package com.edu.domain.repository;

import com.edu.domain.Order;

/**
 * Created by ed on 4/25/16.
 */

public interface OrderRepository {

    Long saveOrder(Order order);
}
