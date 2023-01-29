package com.thelathereddragon.usecases;

import com.thelathereddragon.entities.Product;
import com.thelathereddragon.ports.ProductRepo;

public class CreateProduct {
  private ProductRepo productRepo;

  public CreateProduct(ProductRepo productRepo) {
    this.productRepo = productRepo;
  }

  public void execute(Product product) {
    productRepo.save(product);
  }
}
