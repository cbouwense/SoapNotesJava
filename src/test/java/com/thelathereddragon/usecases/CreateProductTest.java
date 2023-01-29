package com.thelathereddragon.usecases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.thelathereddragon.entities.Product;
import com.thelathereddragon.ports.ProductRepo;
import com.thelathereddragon.repos.InMemoryProductRepo;

public class CreateProductTest {
  ProductRepo productRepo;
  CreateProduct createProduct;
  Product product;

  @Before
  public void setup() {
    productRepo = new InMemoryProductRepo();
    createProduct = new CreateProduct(productRepo);
    product = new Product();
  }

  @Test
  public void executeSavesToRepo() {
    createProduct.execute(product);
    Product productFromRepo = productRepo.fetch(product);

    assertEquals(productFromRepo, product);
  }
}
