package com.store.productcatalog.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "product_code")
    int productCode;
    @Column(name = "product_name")
    String productName;
    @Column(name = "product_brand")
    String productBrand;
    @Column(name = "unit_price")
    int unitPrice;
    @Column(name = "quantity")
    int quantity;



}
