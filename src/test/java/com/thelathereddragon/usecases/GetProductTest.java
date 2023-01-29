package com.thelathereddragon.usecases;

import static com.thelathereddragon.entities.UnitOfMeasurement.OUNCE;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.thelathereddragon.entities.Amount;
import com.thelathereddragon.entities.Product;
import com.thelathereddragon.ports.ProductRepo;
import com.thelathereddragon.repos.InMemoryProductRepo;

public class GetProductTest {
  private ProductRepo productRepo;
  private Product product;

  @Before
  public void setup() {
    productRepo = new InMemoryProductRepo();
    product = new Product(
        1,
        "Redner's Olive Oil",
        "The big bottle at Redner's",
        1000,
        new Amount(51, OUNCE)
    );

    productRepo.save(product);
  }

  @Test
  public void executeReturnsProductFromRepo() {
    GetProduct getProduct = new GetProduct(productRepo);
    Product productFromRepo = getProduct.execute(product);

    assertEquals(productFromRepo.id, product.id);
    assertEquals(productFromRepo.name, product.name);
    assertEquals(productFromRepo.description, product.description);
    assertEquals(productFromRepo.netWeight.value, product.netWeight.value, 0.0);
    assertEquals(productFromRepo.netWeight.unit, product.netWeight.unit);
  }
}
