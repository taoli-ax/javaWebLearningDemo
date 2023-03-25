package com.Dao;

import com.Dao.Impl.GoodsDaoImpl;
import com.POJO.Cart;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

public interface CartDao {
    public Cart findCartByUserIdAndGoodId(@Param("userId") long userId,@Param("goodsId") long goodsId);
    public int addToCart(Cart cart);
    public void updateQuantityById(@Param("goodId") long goodsId);
    public void updateCart(Cart cart);
    public List<Cart> queryUserCart(long userId);
}
