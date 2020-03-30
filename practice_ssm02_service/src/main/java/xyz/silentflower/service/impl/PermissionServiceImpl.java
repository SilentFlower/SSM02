package xyz.silentflower.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.silentflower.dao.PermissionDao;
import xyz.silentflower.domain.Permission;
import xyz.silentflower.service.PermissionService;

import java.util.List;
import java.util.UUID;

/**
 * @author SiletFlower
 * @date 2020/3/27 02:36:13
 * @description
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(Permission permission) {
        permission.setId(UUID.randomUUID().toString().replace("-",""));
        return permissionDao.save(permission);
    }

    @Override
    public Permission findByPerId(String id) {
        return permissionDao.findByPerId(id);
    }

    @Override
    public int deleteById(String id) {
        permissionDao.deleteFromRole_PerId(id);
        permissionDao.deleteFromPerId(id);
        return 0;
    }


}
