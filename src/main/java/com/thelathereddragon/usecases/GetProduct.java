package com.thelathereddragon.usecases;

import com.thelathereddragon.entities.Product;
import com.thelathereddragon.ports.ProductRepo;

public class GetProduct {
  private ProductRepo productRepo;

  public GetProduct(ProductRepo productRepo) {
    this.productRepo = productRepo;
  }

  public Product execute(Product product) {
    return productRepo.fetch(product);
  }
}
