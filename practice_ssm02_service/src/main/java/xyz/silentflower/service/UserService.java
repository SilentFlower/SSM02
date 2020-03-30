package xyz.silentflower.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import xyz.silentflower.domain.Role;
import xyz.silentflower.domain.UserInfo;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/23 22:39:43
 * @description
 */
public interface UserService extends UserDetailsService {

   public List<UserInfo> findAll();

   public int save(UserInfo user);

   public UserInfo findById(String id);

    public List<Role> findOtherRole(String id);

    public int addRoleToUser(String userId, String[] ids);
}
