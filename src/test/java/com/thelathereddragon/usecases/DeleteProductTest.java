package com.thelathereddragon.usecases;

import static com.thelathereddragon.entities.UnitOfMeasurement.OUNCE;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.thelathereddragon.entities.Amount;
import com.thelathereddragon.entities.Product;
import com.thelathereddragon.ports.ProductRepo;
import com.thelathereddragon.repos.InMemoryProductRepo;

public class DeleteProductTest {
  private ProductRepo productRepo;
  private Product product;

  @Before
  public void setup() {
    productRepo = new InMemoryProductRepo();
    product = new Product(
        1,
        "Redner's Olive Oil",
        "The big jug at Redner's",
        1000,
        new Amount(51, OUNCE)
    );

    productRepo.save(product);
  }
  
  @Test
  public void executeDeletesFromRepo() {
    DeleteProduct deleteProduct = new DeleteProduct(productRepo);
    deleteProduct.execute(product);
    Product productFromRepo = productRepo.fetch(product);
    
    assertEquals(productFromRepo, null);
  }
}