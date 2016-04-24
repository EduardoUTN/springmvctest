package com.edu.repository;

import com.edu.domain.Cart;

/**
 * Created by ed on 4/23/16.
 */
public interface CartRepository {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);
}
