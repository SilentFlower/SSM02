package xyz.silentflower.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.silentflower.dao.RoleDao;
import xyz.silentflower.domain.Permission;
import xyz.silentflower.domain.Role;
import xyz.silentflower.service.RoleService;

import java.util.List;
import java.util.UUID;

/**
 * @author SiletFlower
 * @date 2020/3/27 01:55:54
 * @description
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(Role role) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        role.setId(uuid);
        return roleDao.save(role);
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public int deleteById(String id) {
        roleDao.deleteFromRole_permissionById(id);
        roleDao.deleteFromUser_roleById(id);
        roleDao.deleteRoleById(id);
        return 0;
    }

    @Override
    public List<Permission> findCanAddPermission(String id) {
        return roleDao.findCanAddPermission(id);
    }

    @Override
    public int addPermission(String roleId, List ids) {
        for (Object id : ids) {
            roleDao.addPermission(roleId, (String) id);
        }
        return 0;
    }
}
