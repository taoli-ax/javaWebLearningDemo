package com.POJO;

import java.math.BigDecimal;

public class Goods {
    private long id;
    private String name;
    private String serial;
    private String author;
    private String publisher;
    private String public_time;
    private long category_id;
    private String caption;
    private String image;
    private int inventory;
    private BigDecimal market_price;
    private BigDecimal retail_price;
    private double comment_score;
    private int comment_num;
    private String available_time;
    private int sales;
    private String is_new;
    private String is_sale_well;
    private String goods_states;

    public Goods(long id, String name, String serial, String author, String publisher, String public_time, long category_id, String caption, String image, int inventory, BigDecimal market_price, BigDecimal retail_price, double comment_score, int comment_num, String available_time, int sales, String is_new, String is_sale_well, String goods_states) {
        this.id = id;
        this.name = name;
        this.serial = serial;
        this.author = author;
        this.publisher = publisher;
        this.public_time = public_time;
        this.category_id = category_id;
        this.caption = caption;
        this.image = image;
        this.inventory = inventory;
        this.market_price = market_price;
        this.retail_price = retail_price;
        this.comment_score = comment_score;
        this.comment_num = comment_num;
        this.available_time = available_time;
        this.sales = sales;
        this.is_new = is_new;
        this.is_sale_well = is_sale_well;
        this.goods_states = goods_states;
    }

    public Goods() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublic_time() {
        return public_time;
    }

    public void setPublic_time(String public_time) {
        this.public_time = public_time;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public BigDecimal getMarket_price() {
        return market_price;
    }

    public void setMarket_price(BigDecimal market_price) {
        this.market_price = market_price;
    }

    public BigDecimal getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(BigDecimal retail_price) {
        this.retail_price = retail_price;
    }

    public double getComment_score() {
        return comment_score;
    }

    public void setComment_score(double comment_score) {
        this.comment_score = comment_score;
    }

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public String getAvailable_time() {
        return available_time;
    }

    public void setAvailable_time(String available_time) {
        this.available_time = available_time;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getIs_new() {
        return is_new;
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    public String getIs_sale_well() {
        return is_sale_well;
    }

    public void setIs_sale_well(String is_sale_well) {
        this.is_sale_well = is_sale_well;
    }

    public String getGoods_states() {
        return goods_states;
    }

    public void setGoods_states(String goods_states) {
        this.goods_states = goods_states;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serial='" + serial + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", public_time='" + public_time + '\'' +
                ", category_id=" + category_id +
                ", caption='" + caption + '\'' +
                ", image='" + image + '\'' +
                ", inventory=" + inventory +
                ", market_price=" + market_price +
                ", retail_price=" + retail_price +
                ", comment_score=" + comment_score +
                ", comment_num=" + comment_num +
                ", available_time='" + available_time + '\'' +
                ", sales=" + sales +
                ", is_new='" + is_new + '\'' +
                ", is_sale_well='" + is_sale_well + '\'' +
                ", goods_states='" + goods_states + '\'' +
                '}';
    }
}
