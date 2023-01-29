package com.thelathereddragon.usecases;

import com.thelathereddragon.entities.Product;
import com.thelathereddragon.ports.ProductRepo;

public class GetProductByName {
  private ProductRepo productRepo;

  public GetProductByName(ProductRepo productRepo) {
    this.productRepo = productRepo;
  }

  public Product execute(String name) {
    return productRepo.fetch(name);
  }
}
