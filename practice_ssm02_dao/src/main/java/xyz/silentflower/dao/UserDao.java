package xyz.silentflower.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import xyz.silentflower.domain.Role;
import xyz.silentflower.domain.UserInfo;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/24 02:17:36
 * @description
 */
@Repository
public interface UserDao {

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "xyz.silentflower.dao.RoleDao.findByUserId"))
    })
    public UserInfo findByUsername(String username);

    @Select("select * from users")
    public List<UserInfo> findAll();

    @Insert("insert into users (id,email,username,password,phoneNum,status) values(#{id}, #{email}, #{username}, #{password}, #{phoneNum}, #{status})")
    public int save(UserInfo user);

    @Select("select * from users where id = #{id}")
    @Results({
        @Result(property = "id",column = "id"),
        @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "xyz.silentflower.dao.RoleDao.findByUserId"))
    })
    public UserInfo findById(String id);



    @Select("select * from role where id not in(select roleId from users_role where userId = #{id})")
    public List<Role> findOtherRole(String id);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{id})")
    public int addRoleToUser(@Param("userId") String userId, @Param("id") String id);
}
