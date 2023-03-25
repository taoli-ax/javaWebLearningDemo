package com.services;

import com.POJO.Cart;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface CartService {

    public Cart addToCart(long goodsId, long userId, int quantity, BigDecimal price) throws IOException;
    public void updateCart(Cart cart);
    public List<Cart> queryUserCart(long userId);
}
