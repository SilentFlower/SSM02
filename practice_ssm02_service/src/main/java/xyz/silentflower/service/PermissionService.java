package xyz.silentflower.service;

import xyz.silentflower.domain.Permission;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/27 02:35:49
 * @description
 */
public interface PermissionService {
    public List<Permission> findAll();

    public int save(Permission permission);

    public Permission findByPerId(String id);

    public int deleteById(String id);
}
