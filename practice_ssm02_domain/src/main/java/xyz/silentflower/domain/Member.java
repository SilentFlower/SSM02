package xyz.silentflower.domain;

import lombok.Data;

/**
 * @author SiletFlower
 * @date 2020/3/21 09:50:29
 * @description
 */

//会员
@Data
public class Member {
    private String id;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;
}
