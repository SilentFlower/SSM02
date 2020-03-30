package xyz.silentflower.domain;

import lombok.Data;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/24 02:12:13
 * @description
 */
@Data
public class Permission {
    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
