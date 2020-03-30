package xyz.silentflower.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xyz.silentflower.domain.Traveller;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/23 12:38:05
 * @description
 */
@Repository
public interface TravellerDao {
    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId = #{id})")
    public List<Traveller> findById(String id);
}
