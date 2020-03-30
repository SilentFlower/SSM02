package xyz.silentflower.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import xyz.silentflower.domain.Member;
import xyz.silentflower.domain.Orders;
import xyz.silentflower.domain.Product;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/21 10:06:27
 * @description
 */
@Repository
public interface OrderDao {

    @Select("select * from orders")
    @Results({
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "xyz.silentflower.dao.ProductDao.findById")),
    })
    public List<Orders> findAll();

    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "xyz.silentflower.dao.MemberDao.findById")),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "xyz.silentflower.dao.ProductDao.findById")),
            @Result(property = "travellers",column ="id" ,javaType = java.util.List.class,many =@Many(select = "xyz.silentflower.dao.TravellerDao.findById"))
    })
    public Orders findById(String id);
}
