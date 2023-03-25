package com.Dao;

import com.POJO.Goods;
import com.POJO.PageBean;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public interface GoodsDao {
    public List<Goods> FindNewGoods() throws IOException;
    public List<Goods> FindHotGoods() throws IOException;
    public Goods GoodsDetail(String serial) throws IOException;
    public List<Goods> findGoodsByCategoryAndPage(@Param("id") int id, @Param("index") int index,@Param("pageSize") int pageSize) throws IOException;
    public int findGoodsByCategoryId(int id) throws IOException;

}
