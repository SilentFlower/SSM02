package xyz.silentflower.domain;

import lombok.Data;
import xyz.silentflower.util.DateUtils;

import java.util.Date;

/**
 * @author SiletFlower
 * @date 2020/3/30 20:33:01
 * @description
 */
@Data
public class SysLog {
    private String id;
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;

    public String getVisitTimeStr() {
        visitTimeStr = DateUtils.data2String(visitTime, "yyyy-MM-dd HH:mm:ss");
        return visitTimeStr;
    }
}
