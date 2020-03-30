package xyz.silentflower.service;

import xyz.silentflower.domain.Permission;
import xyz.silentflower.domain.Role;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/27 01:55:12
 * @description
 */
public interface RoleService {
    public List<Role> findAll();

    public int save(Role role);

    public Role findById(String id);

    public int deleteById(String id);

    public List<Permission> findCanAddPermission(String id);

    public int addPermission(String roleId, List ids);
}
