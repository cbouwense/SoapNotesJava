package com.thelathereddragon.usecases;

import static com.thelathereddragon.entities.UnitOfMeasurement.GRAMS;
import static com.thelathereddragon.entities.UnitOfMeasurement.OUNCES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.thelathereddragon.entities.Amount;
import com.thelathereddragon.entities.Product;
import com.thelathereddragon.ports.ProductRepo;
import com.thelathereddragon.repos.InMemoryProductRepo;

public class GetAllProductsTest {
    private ProductRepo productRepo;
    private Product product1;
    private Product product2;
    private Product product3;

    @Before
    public void beforeEach() {
        productRepo = new InMemoryProductRepo();
        product1 = new Product("test-product-1", "foo", 42, new Amount(1337, OUNCES));
        product2 = new Product("test-product-2", "bar", 17, new Amount(9001, GRAMS));
        product3 = new Product("test-product-3", "baz", 38, new Amount(24, OUNCES));

        productRepo.save(product1);
        productRepo.save(product2);
        productRepo.save(product3);
    }

    @Test
    public void executeReturnsCorrectAmountOfProductsFromRepo() {
        GetAllProducts getAllProducts = new GetAllProducts(productRepo);
        Product[] productsFromRepo = getAllProducts.execute();

        assertEquals(3, productsFromRepo.length);
    }

    @Test
    public void executeReturnsCorrectProductsFromRepo() {
        GetAllProducts getAllProducts = new GetAllProducts(productRepo);
        Product[] productsFromRepo = getAllProducts.execute();

        assertTrue(product1.equals(productsFromRepo[0]));
        assertTrue(product2.equals(productsFromRepo[1]));
        assertTrue(product3.equals(productsFromRepo[2]));
    }

    @Test
    public void executeReturnsEmptyArrayWhenRepoEmpty() {
        productRepo.delete(product1);
        productRepo.delete(product2);
        productRepo.delete(product3);
        Product[] productsFromRepo = new GetAllProducts(productRepo).execute();

        assertEquals(0, productsFromRepo.length);
    }
}
