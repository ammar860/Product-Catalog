package com.store.productcatalog.contoller;

import com.store.productcatalog.model.Product;
import com.store.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    final
    ProductService service;

    @Autowired
    public MainController(ProductService service) {
        this.service = service;
    }

    @PostMapping(value = "/product")
    public String addProduct(@ModelAttribute Product product){
        service.saveProduct(product);
        return "redirect:/";
    }
    @GetMapping(value = "/deleteproduct/{id}")
    public String deleteProduct(@PathVariable Integer id){
        service.deleteProduct(id);
        return "redirect:/";
    }
    @PostMapping(value = "/editprod/{id}")
    public String editProduct( @PathVariable Integer id , @ModelAttribute Product product){
        Product product1 = service.getProductById(id);
        product1.setProductName(product.getProductName());
        product1.setProductCode(product.getProductCode());
        product1.setProductBrand(product.getProductBrand());
        product1.setUnitPrice(product.getUnitPrice());
        product1.setQuantity(product.getQuantity());
        service.saveProduct(product1);
        return "redirect:/";
    }
    @GetMapping(value = "/product/brand")
    public List<Product> searchByBrand(@RequestParam String brand){
        return service.getByBrand(brand);
    }

}
