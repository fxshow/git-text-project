package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IuserService iuserService;

    /**
     *查询所有用户
     * @return
     */
    @RequestMapping("findAll.do")
    @PreAuthorize("hasRole('ROLE_USER')")//有user权限的可以查询所有
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> list= iuserService.findAll();
        mv.addObject("userList",list);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * 新建用户
     * @param userInfo
     * @return
     */
    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username=='zhangsan'")//zhangsan用户可以新建
    public String save(UserInfo userInfo){
        iuserService.save(userInfo);
        return "redirect:findAll.do";
    }


    /**
     * 详情信息查询
     * @param id
     * @return
     */
    @RequestMapping("/findById.do")
    public  ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo=iuserService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * 查询用户以及用户可以添加的角色
     * @param userid
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public  ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userid){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = iuserService.findById(userid);
        List<Role> otherRole=iuserService.findotherRole(userid);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRole);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     * 添加角色给用户
     * @param userId
     * @param roleIds
     * @return
     */
    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId, @RequestParam(name = "ids",required = true) String[]roleIds){
        iuserService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

}
