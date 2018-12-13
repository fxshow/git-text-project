package com.itheima.controller;

import com.itheima.domain.Product;
import com.itheima.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IproductService productService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN") //必须在spring-security开启注解
    public ModelAndView findAll() {
        System.out.println("11111111111111111111");
        System.out.println(productService);
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll();
        mv.addObject("productList", products);
        mv.setViewName("product-list1");
        return mv;
    }

    /**
     * 新建
     * @param product
     * @return
     */
    @RequestMapping("/save.do")
    public String save(Product product) {
        System.out.println(111111111);
        productService.save(product);
        return "redirect:findAll.do";
    }

    /**
     * 详情
     * @param productId
     * @return
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String productId) {
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(productId);
        mv.addObject("productList", product);
        mv.setViewName("product-show");
        return mv;
    }

    /**
     * 更新
     * @param product
     * @return
     */
    @RequestMapping("/updateProduct.do")
    public ModelAndView updateProduct(Product product) {
        //获取id
        Product product1 = productService.findById(product.getId());
        ModelAndView mv = new ModelAndView();
        mv.addObject("product",product1);
        mv.setViewName("update-product");
        return mv;
    }

    @RequestMapping("/doUpdateProduct.do")
    public String doUpdateProduct(Product product) {
        System.out.println(product);
        System.out.println("1234567890989fghgjhjkkl;l");
        productService.updateProduct(product);
        return "redirect:findAll.do";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteProduct.do")
    public String deleteProduct(String id){
        productService.deleteProduct(id);
        return "redirect:findAll.do";
    }
}
