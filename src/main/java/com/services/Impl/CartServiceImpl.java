package com.services.Impl;

import com.Dao.CartDao;
import com.Dao.Impl.CartDaoImpl;
import com.POJO.Cart;
import com.services.CartService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class CartServiceImpl implements CartService {
    @Override
    public Cart addToCart(long goodsId, long userId, int quantity, BigDecimal price) throws IOException {
        CartDao cartDao=new CartDaoImpl();
        Cart cartExist= cartDao.findCartByUserIdAndGoodId(userId, goodsId);
        if(cartExist==null){
            Cart cart = new Cart();
            cart.setGoods_id(goodsId);
            cart.setUser_id(userId);
            cart.setGoods_quantity(quantity);
            cart.setSubtotal(price.multiply(BigDecimal.valueOf(quantity)));
            cartDao.addToCart(cart);
        }else{
            // 根据cartExist的查询结果，进一步更新金额和数量
            int UpdateQuantity=cartExist.getGoods_quantity()+quantity;
            //数量
            cartExist.setGoods_quantity(UpdateQuantity);
            //金额
            BigDecimal UpdateSubtotal=new BigDecimal(String.valueOf(price)).multiply(BigDecimal.valueOf(UpdateQuantity));
            cartExist.setSubtotal(UpdateSubtotal);
            //调用Dao更新数据库
            cartDao.updateCart(cartExist);
        }
        return null;
    }

    @Override
    public void updateCart(Cart cart) {

    }

    @Override
    public List<Cart> queryUserCart(long userId) {
        CartDao cartDao=new CartDaoImpl();
        return cartDao.queryUserCart(userId);

    }

}
