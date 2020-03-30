package xyz.silentflower.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author SiletFlower
 * @date 2020/3/26 02:35:00
 * @description
 */
public class BCryptPasswordEncoderUtil {
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public static String encodePassword(String s){
        return encoder.encode(s);
    }
}
