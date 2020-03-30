package xyz.silentflower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xyz.silentflower.domain.Product;
import xyz.silentflower.service.ProductService;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/20 01:13:27
 * @description
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/save.do")
    public String save(Product product){
        System.out.println("1");
        productService.save(product);
        return "redirect:findAll.do";
    }


    //查询全部产品
    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> all = productService.findAll();
        mv.addObject("productList",all);
        mv.setViewName("product-list1");
        return mv;
    }

}
