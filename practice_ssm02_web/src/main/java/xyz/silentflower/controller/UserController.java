package xyz.silentflower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import xyz.silentflower.domain.Role;
import xyz.silentflower.domain.UserInfo;
import xyz.silentflower.service.UserService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/25 02:43:18
 * @description
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> users = userService.findAll();
        mv.addObject("userList", users);
        mv.setViewName("user-list");

        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo user){
        userService.save(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id){
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(id);
        mv.addObject("user",user).setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true)String id){
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(id);
        List<Role> otherRole = userService.findOtherRole(id);
        mv.addObject("roleList",otherRole).addObject("user",user)
                .setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId")String userId,@RequestParam(name = "ids")String[] ids){
        userService.addRoleToUser(userId,ids);
        return "redirect:findAll.do";
    }



}
