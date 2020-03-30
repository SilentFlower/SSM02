package xyz.silentflower.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import xyz.silentflower.util.DateUtils;

import java.util.Date;

/**
 * @author SiletFlower
 * @date 2020/3/19 23:33:41
 * @description
 */
@Data
public class Product {
    private String id;//主键
    private String productNum;//编号
    private String productName;//名称
    private String cityName;//出发城市
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date DepartureTime;//出发时间
    private String DepartureTimeStr;
    private Double productPrice;//产品价格
    private String productDesc;//产品描述
    private Integer productStatus;//状态 0关闭 1开启
    private String productStatusStr;

    public String getProductStatusStr(){
        if(productStatus != null){
            if(productStatus == 0){
                productStatusStr="关闭";
            }else if (productStatus == 1){
                productStatusStr="开启";
            }
        }
        return productStatusStr;
    }

    public String getDepartureTimeStr() {
        if(DepartureTime != null){
            DepartureTimeStr = DateUtils.data2String(DepartureTime,"yyyy-MM-dd HH:mm:ss");
        }
        return DepartureTimeStr;
    }


}
