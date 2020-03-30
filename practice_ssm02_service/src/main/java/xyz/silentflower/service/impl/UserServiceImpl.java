package xyz.silentflower.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.silentflower.dao.UserDao;
import xyz.silentflower.domain.Role;
import xyz.silentflower.domain.UserInfo;
import xyz.silentflower.service.UserService;
import xyz.silentflower.util.BCryptPasswordEncoderUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author SiletFlower
 * @date 2020/3/23 22:40:04
 * @description
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo inf = userDao.findByUsername(username);
        User user = new User(inf.getUsername(),inf.getPassword(),inf.getStatus() == 0 ? false:true,true,true,true,getAuthority(inf.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public int save(UserInfo user) {
        String id = UUID.randomUUID().toString().replace("-", "");
        user.setId(id);
        user.setPassword(BCryptPasswordEncoderUtil.encodePassword(user.getPassword()));
        return userDao.save(user);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findOtherRole(String id) {
        return userDao.findOtherRole(id);
    }

    @Override
    public int addRoleToUser(String userId, String[] ids) {
        for (String id : ids) {
            userDao.addRoleToUser(userId,id);
        }
        return 0;
    }
}
