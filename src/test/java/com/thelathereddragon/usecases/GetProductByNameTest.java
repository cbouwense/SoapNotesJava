package com.thelathereddragon.usecases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.thelathereddragon.entities.Product;
import com.thelathereddragon.ports.ProductRepo;
import com.thelathereddragon.repos.InMemoryProductRepo;

public class GetProductByNameTest {
  ProductRepo productRepo;
  GetProductByName getProductByName;;
  private Product product1, product2;
  
  @Before
  public void setup() {
    productRepo = new InMemoryProductRepo();
    getProductByName = new GetProductByName(productRepo);

    product1 = new Product();
    product1.setName("Test Product 1");
    product2 = new Product();
    product2.setName("Test Product 2");
  }

  @Test
  public void executeGetsFromRepo() {
    productRepo.save(product1);
    Product productFromRepo = getProductByName.execute(product1.getName());
    
    assertEquals(product1, productFromRepo);
  }

  @Test
  public void executeGetsFromRepoWhenMultipleProducts() {
    productRepo.save(product1);
    productRepo.save(product2);
    Product productFromRepo = getProductByName.execute(product2.getName());
    
    assertEquals(product2, productFromRepo);
  }

  @Test
  public void executeReturnsNullWhenProductDoesNotExist() {
    Product productFromRepo = getProductByName.execute(product1.getName());
    
    assertEquals(null, productFromRepo);
  }
}
