package com.store.productcatalog.contoller;

import com.store.productcatalog.model.Product;
import com.store.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {
    final
    ProductService service;

    @Autowired
    public ViewController(ProductService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String mainPage(){
        return "index";
    }
    @GetMapping(value = "/add")
    public String add(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "add";
    }
    @GetMapping(value = "/editproduct/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Product product = service.getProductById(id);
        model.addAttribute("product",product);
        model.addAttribute("id",id);
        return "edit";
    }
    @GetMapping(value = "/viewable")
    public String viewAll(Model model){

        List<Product> productList = service.getProducts();
        model.addAttribute("productList",productList);
        return "view";
    }
    @GetMapping(value = "/byPrice")
    public String byPrice(Model model){
        int show =0;
        List<Product> productList = new ArrayList<>();
        Product product = new Product();
        model.addAttribute("product",product);
        model.addAttribute("show",show);
        model.addAttribute("productList",productList);
        return "byPrice";
    }
    @PostMapping(value = "/prodbyprice")
    public String ShowByPrice(@ModelAttribute Product product, Model model){
        int show =1;
        List<Product> productList = service.getByPrice(product.getUnitPrice());
        model.addAttribute("show",show);
        model.addAttribute("product",product);
        model.addAttribute("productList",productList);
        return "byPrice";
    }
    @GetMapping(value = "/byBrand")
    public String byBrand(Model model){
        int show =0;
        List<Product> productList = new ArrayList<>();
        Product product = new Product();
        model.addAttribute("product",product);
        model.addAttribute("show",show);
        model.addAttribute("productList",productList);
        return "byBrand";
    }
    @PostMapping(value = "/prodbybrand")
    public String ShowByBrand(@ModelAttribute Product product, Model model){
        int show =1;
        List<Product> productList = service.getByBrand(product.getProductBrand());
        model.addAttribute("show",show);
        model.addAttribute("product",product);
        model.addAttribute("productList",productList);
        return "byBrand";
    }
}
