package com.thelathereddragon.usecases;

import static com.thelathereddragon.entities.UnitOfMeasurement.OUNCES;
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
        "Redner's Olive Oil",
        "The big jug at Redner's",
        1000,
        new Amount(51, OUNCES)
    );

    productRepo.save(product);
  }

  @Test
  public void executeReturnsProductFromRepo() {
    GetProduct getProduct = new GetProduct(productRepo);
    Product productFromRepo = getProduct.execute(product);

    assertEquals(productFromRepo.getName(), product.getName());
    assertEquals(productFromRepo.getDescription(), product.getDescription());
    assertEquals(productFromRepo.getNetWeight().getValue(), product.getNetWeight().getValue(), 0.0);
    assertEquals(productFromRepo.getNetWeight().getUnit(), product.getNetWeight().getUnit());
  }
}
