package com.POJO;

import java.math.BigDecimal;

public class Cart {


    private long id;
    private long user_id;
    private long goods_id;
    private int goods_quantity;
    private BigDecimal subtotal;
    private Goods goods;

    public Cart(long id, long user_id, long goods_id, int goods_quantity, BigDecimal subtotal, Goods goods) {
        this.id = id;
        this.user_id = user_id;
        this.goods_id = goods_id;
        this.goods_quantity = goods_quantity;
        this.subtotal = subtotal;
        this.goods = goods;
    }

    public Cart() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGoods_quantity() {
        return goods_quantity;
    }

    public void setGoods_quantity(int goods_quantity) {
        this.goods_quantity = goods_quantity;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(long goods_id) {
        this.goods_id = goods_id;
    }


    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", goods_id=" + goods_id +
                ", goods_quantity=" + goods_quantity +
                ", subtotal=" + subtotal +
                ", goods=" + goods +
                '}';
    }
}
