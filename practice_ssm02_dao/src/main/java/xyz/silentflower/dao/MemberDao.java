package xyz.silentflower.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xyz.silentflower.domain.Member;

/**
 * @author SiletFlower
 * @date 2020/3/23 12:20:30
 * @description
 */
@Repository
public interface MemberDao {
    @Select("select * from member where id = #{id}")
    public Member findById(String id);
}
