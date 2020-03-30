package xyz.silentflower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.silentflower.domain.SysLog;
import xyz.silentflower.service.SysLogService;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/31 01:00:57
 * @description
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<SysLog> syslogs = sysLogService.findAll();
        mv.addObject("sysLogs",syslogs).setViewName("syslog-list");
        return mv;
    }
}
