package com.itheima.controller;

import com.itheima.domain.Permission;
import com.itheima.service.IpermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IpermissionService ipermissionService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<Permission> list = ipermissionService.findAll();
        mv.addObject("permissionList",list);
        mv.setViewName("permission-list");
        return mv;
    }

    /**
     * 新建
     * @param permission
     * @return
     */
    @RequestMapping("/save.do")
    public String save(Permission permission){
        ipermissionService.save(permission);
        return "redirect:findAll.do";
    }

    /**
     * 详情
     * @param permissionId
     * @return
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String permissionId) {
        ModelAndView mv = new ModelAndView();
        Permission permission = ipermissionService.findById(permissionId);
        mv.addObject("permissionList", permission);
        mv.setViewName("permission-show");
        return mv;
    }

    /**
     * 更新
     * @param id
     * @return
     */
    @RequestMapping("/updatePermission.do")
    public ModelAndView updatePermission(String id) {
        ModelAndView mv = new ModelAndView();
        Permission permission = ipermissionService.findById(id);
        mv.addObject("permission", permission);
        mv.setViewName("update-permission");
        return mv;
    }
    @RequestMapping("/doUpdatePermission.do")
    public String doUpdatePermission(Permission permission) {
       ipermissionService.UpdatePermission(permission);
       return "redirect:findAll.do";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("deletePermission.do")
    public String deletePermission(String id){
        ipermissionService.deletePermission(id);
        return "redirect:findAll.do";
    }

}
