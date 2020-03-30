package xyz.silentflower.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.silentflower.dao.SysLogDao;
import xyz.silentflower.domain.SysLog;
import xyz.silentflower.service.SysLogService;

import java.util.List;
import java.util.UUID;

/**
 * @author SiletFlower
 * @date 2020/3/30 22:16:00
 * @description
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;


    @Override
    public void Insert(SysLog sysLog) {
        String id = UUID.randomUUID().toString().replace("-", "");
        sysLog.setId(id);
        sysLogDao.Insert(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
