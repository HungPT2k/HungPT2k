package com.example.th2_nhom14.controller;

import com.example.th2_nhom14.model.Product;
import com.example.th2_nhom14.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller

public class ProductController {
    @Autowired
 private ProductService productService;
    @RequestMapping(value = "/")
    public String viewHomePage(Model model) {
        List<Product> listProducts = productService.getAll();
        model.addAttribute("listProducts", listProducts);
     return "index";
    }
    @RequestMapping(value = "/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "newProduct";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") String id) {
        ModelAndView mav = new ModelAndView("editProduct");
        Optional<Product> product = productService.get(id);
        mav.addObject("product", product);

        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") String id) {
        productService.delete(id);
        return "redirect:/";
    }
}
