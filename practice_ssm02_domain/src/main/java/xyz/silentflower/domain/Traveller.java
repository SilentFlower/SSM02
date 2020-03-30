package xyz.silentflower.domain;

import lombok.Data;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * @author SiletFlower
 * @date 2020/3/21 09:51:09
 * @description
 */
//旅客
@Data
public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;
    private String travellerTypeStr;

    public String getCredentialsTypeStr() {
        if(credentialsType == 0){
            credentialsTypeStr="身份证";
        }else if(credentialsType == 1){
            credentialsTypeStr = "护照";
        }else if(credentialsType== 2){
            credentialsTypeStr = "军官证";
        }
        return credentialsTypeStr;
    }

    public String getTravellerTypeStr() {
        if(travellerType==0){
            travellerTypeStr = "成人";
        }else if(travellerType==1){
            travellerTypeStr = "儿童";
        }
        return travellerTypeStr;
    }
}
