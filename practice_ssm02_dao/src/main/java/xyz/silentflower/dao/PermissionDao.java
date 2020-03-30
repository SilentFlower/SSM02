package xyz.silentflower.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xyz.silentflower.domain.Permission;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/27 01:07:03
 * @description
 */
@Repository
public interface PermissionDao {

    @Select("select * from permission where id in(select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findById(String id);

    @Select("select * from permission")
    public List<Permission> findAll();

    @Insert("insert into permission(id,permissionName,url) values(#{id},#{permissionName},#{url})")
    public int save(Permission Permission);

    @Select("select * from permission where id=#{id}")
    public Permission findByPerId(String id);

    @Delete("delete from role_permission where permissionId=#{id}")
    public int deleteFromRole_PerId(String id);

    @Delete("delete from permission where id=#{id}")
    public int deleteFromPerId(String id);
}
