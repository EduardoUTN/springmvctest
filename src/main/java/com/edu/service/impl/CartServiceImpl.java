package com.edu.service.impl;


import com.edu.domain.Cart;
import com.edu.domain.repository.CartRepository;
import com.edu.exception.InvalidCartException;
import com.edu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ed on 4/23/16.
 */

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    public Cart create(Cart cart) {
        return cartRepository.create(cart);
    }

    public Cart read(String cartId) {
        return cartRepository.read(cartId);
    }

    public void update(String cartId, Cart cart) {
        cartRepository.update(cartId, cart);
    }

    public void delete(String cartId) {
        cartRepository.delete(cartId);
    }

    public Cart validate(String cartId) {
        Cart cart = cartRepository.read(cartId);
        if(cart == null || cart.getCartItems().size() == 0) {
            throw new InvalidCartException(cartId);
        }
        return cart;
    }
}
