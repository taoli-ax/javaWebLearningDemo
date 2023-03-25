package com.Dao.Impl;

import com.Dao.CartDao;
import com.Dao.GoodsDao;
import com.POJO.Cart;
import com.services.Impl.CartServiceImpl;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CartDaoImpl implements CartDao {
    private final SqlSession sqlSession= MybatisUtils.getSqlSession();
    CartDao cartDao=sqlSession.getMapper(CartDao.class);

    @Override
    public Cart findCartByUserIdAndGoodId(long userId, long goodsId) {
        return cartDao.findCartByUserIdAndGoodId(userId,goodsId);
    }

    @Override
    public int addToCart(Cart cart) {
        int num=cartDao.addToCart(cart);
        return 0;
    }

    @Override
    public void updateQuantityById(long goodsId) {
        cartDao.updateQuantityById(goodsId);
    }

    @Override
    public void updateCart(Cart cart) {
        cartDao.updateCart(cart);
    }

    @Override
    public List<Cart> queryUserCart(long userId) {
        return cartDao.queryUserCart(userId);
    }
}
