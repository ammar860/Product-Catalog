package com.store.productcatalog.repository;

import com.store.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdRepository extends JpaRepository<Product,Integer> {

    List<Product> findProductsByProductBrand(String brand);

    List<Product> findProductsByUnitPriceGreaterThan(int price);
}
