package xyz.silentflower.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xyz.silentflower.domain.Product;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/19 23:47:46
 * @description
 */
@Repository
public interface ProductDao {
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Insert("insert into product(id,productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus)" +
            "values(#{id},#{productNum},#{productName},#{cityName},#{DepartureTime},#{productPrice},#{productDesc},#{productStatus}) ")
    public void save(Product product);

    @Select("select * from product where id=#{id}")
    public Product findById(String id);
}
