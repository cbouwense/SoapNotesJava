package com.thelathereddragon.repos;

import java.util.ArrayList;
import java.util.List;

import com.thelathereddragon.entities.Product;
import com.thelathereddragon.ports.ProductRepo;

public class InMemoryProductRepo implements ProductRepo {
  List<Product> products = new ArrayList<>();

  @Override
  public void save(Product product) {
    products.add(product);
  }

  @Override
  public Product fetch(Product product) {
    return products.stream()
        .filter(p -> p.equals(product))
        .findFirst()
        .orElse(null);
  }
}
