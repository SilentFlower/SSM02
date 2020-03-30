package xyz.silentflower.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import xyz.silentflower.domain.SysLog;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/30 22:16:38
 * @description
 */
public interface SysLogDao {

    @Insert("insert into syslog(id,visitTime,username,ip,url,executionTime,method)" +
            "values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void Insert(SysLog sysLog);

    @Select("select * from syslog")
    public List<SysLog> findAll();
}
