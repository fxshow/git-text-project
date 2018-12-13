package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IproductDao {
    /**
     * 根据id查询产品
     * @return
     */
    //根据id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(String id);

    /**
     * 查询所有
     * @return
     */
    @Select("select * from product")
    public List<Product> findAll();

    /**
     * 保存产品
     * @param product
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    /**
     * 修改产品
     * @param product
     */
    @Update("update product set productNum=#{productNum} ,productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    void updateProduct(Product product);

    /**
     * 删除
     * @param id
     */
    @Delete("delete from product where id=#{id}")
    void deleteProduct(String id);
}
