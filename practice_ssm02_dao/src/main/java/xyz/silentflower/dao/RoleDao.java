package xyz.silentflower.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.silentflower.domain.Permission;
import xyz.silentflower.domain.Role;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/24 11:37:00
 * @description
 */
@Repository
public interface RoleDao {
    @Select("select * from role where id in(select roleId from users_role where userId=#{id})")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "xyz.silentflower.dao.PermissionDao.findById"))
    })
    public List<Role> findByUserId(String id);


    @Select("select * from role")
    public List<Role> findAll();

    @Insert("insert into role(id,roleName,roleDesc) values(#{id},#{roleName},#{roleDesc})")
    public int save(Role role);

    @Select("select * from role where id = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "xyz.silentflower.dao.PermissionDao.findById"))
    })
    public Role findById(String id);


    @Delete("delete from role where id=#{id}")
    public void deleteRoleById(String id);

    @Delete("delete from users_role where roleId=#{id}")
    public void deleteFromUser_roleById(String id);

    @Delete("delete from role_permission where roleId=#{id}")
    public void deleteFromRole_permissionById(String id);

    @Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findCanAddPermission(String id);

    @Insert("insert into role_permission(permissionId,roleId) values(#{id},#{roleId})")
    public int addPermission(@Param("roleId") String roleId,@Param("id") String id);
}
