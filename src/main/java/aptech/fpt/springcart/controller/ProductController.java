package aptech.fpt.springcart.controller;

import aptech.fpt.springcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String getList(Model model) {
        model.addAttribute("products", productService.getList());
        return "/product/list";
    }
}
