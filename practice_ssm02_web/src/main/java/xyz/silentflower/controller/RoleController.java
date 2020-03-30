package xyz.silentflower.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import xyz.silentflower.domain.Permission;
import xyz.silentflower.domain.Role;
import xyz.silentflower.service.OrderService;
import xyz.silentflower.service.RoleService;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/27 01:52:54
 * @description
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> all = roleService.findAll();
        mv.addObject("roleList",all);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";

    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id){
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        mv.addObject("role",role).setViewName("role-show");
        return mv;
    }

    @RequestMapping("/deleteById.do")
    public String deleteById(@RequestParam(name = "id",required = true)String id){
        roleService.deleteById(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findCanAddPermission.do")
    public ModelAndView findCanAddPermission(@RequestParam(name = "id",required = true)String id){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissions = roleService.findCanAddPermission(id);
        mv.addObject("permissions",permissions);
        mv.addObject("roleid",id);
        mv.setViewName("role-addPermission");
        return mv;

    }

    @RequestMapping("addPermission.do")
    public String addPermission(@RequestParam(name = "id") String roleId,@RequestParam(name = "ids") List ids){
        roleService.addPermission(roleId,ids);
        return "redirect:findAll.do";
    }


}
