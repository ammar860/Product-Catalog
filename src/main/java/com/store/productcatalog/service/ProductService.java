package com.store.productcatalog.service;

import com.store.productcatalog.model.Product;
import com.store.productcatalog.repository.ProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    final ProdRepository repository;

    @Autowired
    public ProductService(ProdRepository repository) {
        this.repository = repository;
    }

    public void saveProduct(Product product){
        repository.save(product);
    }
    public Product getProductById(int id){
       return repository.findById(id).get();
    }
    public void deleteProduct(int id){
        repository.deleteById(id);
    }
    public List<Product> getProducts(){
        return repository.findAll();
    }
    public List<Product> getByBrand(String brand){
        return repository.findProductsByProductBrand(brand);
    }

    public List<Product> getByPrice(int price){
        return repository.findProductsByUnitPriceGreaterThan(price);
    }
}
