package xyz.silentflower.service;

import xyz.silentflower.domain.SysLog;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/30 22:15:41
 * @description
 */
public interface SysLogService {
    public void Insert(SysLog sysLog);

    public List<SysLog> findAll();
}
