package com.thelathereddragon.ports;

import com.thelathereddragon.entities.Product;

public interface ProductRepo {
  void delete(Product product);
  Product fetch(String name);
  Product fetch(Product product);
  Product[] fetchAll();
  void save(Product product);
}
