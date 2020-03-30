package xyz.silentflower.domain;

import lombok.Data;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/24 02:11:04
 * @description
 */
@Data
public class Role {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<UserInfo> userInfos;
}

