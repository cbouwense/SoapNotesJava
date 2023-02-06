package com.thelathereddragon.usecases;

import com.thelathereddragon.entities.Product;
import com.thelathereddragon.ports.ProductRepo;

public class GetAllProducts {
    private ProductRepo productRepo;

    public GetAllProducts(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product[] execute() {
        return productRepo.fetchAll();
    }
}
