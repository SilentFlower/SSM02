package xyz.silentflower.domain;

import lombok.Data;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/23 22:47:17
 * @description
 */
@Data
public class UserInfo {
    private String id;
    private String email;
    private String username;
    private String password;
    private String phoneNum;
    private Integer status;
    private String statusStr;
    private List<Role> roles;

    public String getStatusStr() {
        if(status == 0){
            statusStr="未开启";
        }else if(status == 1){
            statusStr = "已开启";
        }
        return statusStr;
    }
}
