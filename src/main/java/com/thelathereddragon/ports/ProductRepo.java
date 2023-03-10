package com.thelathereddragon.ports;

import com.thelathereddragon.entities.Product;

public interface ProductRepo {
  void save(Product product);
  Product fetch(Product product);
  void delete(Product product);
  Product fetch(String name);
}
