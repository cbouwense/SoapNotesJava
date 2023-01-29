package com.thelathereddragon.usecases;

import com.thelathereddragon.entities.Product;
import com.thelathereddragon.ports.ProductRepo;

public class DeleteProduct {
  private ProductRepo productRepo;

  public DeleteProduct(ProductRepo productRepo) {
    this.productRepo = productRepo;
  }

  public void execute(Product product) {
    productRepo.delete(product);
  } 
}
