package xyz.silentflower.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import xyz.silentflower.util.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/21 09:50:21
 * @description
 */

//订单
@Data
public class Orders {
    private String id;
    private String orderNum;
    private Date orderTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;
    private int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;

    public String getOrderTimeStr() {
        if(orderTime!=null){
            orderTimeStr = DateUtils.data2String(orderTime,"yyyy-MM-dd HH:mm");
        }

        return orderTimeStr;
    }

    public String getOrderStatusStr() {
        if(orderStatus==0){
            orderStatusStr ="未支付";
        }else if(orderStatus==1){
            orderStatusStr="已支付";
        }
        return orderStatusStr;
    }

    public String getPayTypeStr() {
        if(payType==0){
            payTypeStr = "支付宝";
        }else if (payType==1){
            payTypeStr="微信";
        }else if(payType==2){
            payTypeStr="其他";
        }
        return payTypeStr;
    }
}
