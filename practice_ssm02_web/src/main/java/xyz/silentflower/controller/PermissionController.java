package xyz.silentflower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import xyz.silentflower.domain.Permission;
import xyz.silentflower.service.PermissionService;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/27 02:33:22
 * @description
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Permission> all = permissionService.findAll();
        mv.addObject("permissions",all).setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id){
        Permission permission = permissionService.findByPerId(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("permission",permission).setViewName("permission-show");
        return mv;
    }

    @RequestMapping("/deleteById.do")
    public String deleteById(@RequestParam(name = "id",required = true) String id){
        permissionService.deleteById(id);
        return "redirect:findAll.do";
    }


}
