package com.thelathereddragon.repos;

import static com.thelathereddragon.entities.UnitOfMeasurement.OUNCES;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thelathereddragon.entities.Amount;
import com.thelathereddragon.entities.Product;

public class JsonProductRepoTest {
    Product product;
    String fileName;
    private Gson gson;
    private JsonProductRepo repo;
    private Path toProduct;

    @Before
    public void beforeEach() {
        product = new Product(
            "test-product-2",
            "This is a test product",
            1000,
            new Amount(51, OUNCES)
        );
        toProduct = Paths.get(Constants.productsDirectory + product.getName() + ".json");
        gson = new GsonBuilder().setPrettyPrinting().create();
        repo = new JsonProductRepo(gson);
    }

    @After
    public void afterEach() {
        File f = new File(Constants.productsDirectory + product.getName() + ".json");
        f.delete();
    }

    @Test
    public void saveCreatesFileInFilesystem() {
        repo.save(product);

        File f = new File(toProduct.toString());
        assertTrue(f.isFile());
    }

    @Test
    public void saveCreatesFileWithCorrectJson() throws IOException {
        repo.save(product);

        Reader reader = Files.newBufferedReader(toProduct);
        Product savedProduct = gson.fromJson(reader, Product.class);
        
        assertTrue(product.equals(savedProduct));
    }

    @Test
    public void fetchReturnsProductFromRepo() {
        repo.save(product);
        Product retrievedProduct = repo.fetch(product);

        assertTrue(product.equals(retrievedProduct));
    }

    @Test
    public void fetchRetursNullWhenProductNotInRepo() {
        Product retrievedProduct = repo.fetch(product);

        assertNull(retrievedProduct);
    }

    @Test
    public void fetchByNameReturnsProductFromRepo() {
        repo.save(product);
        Product retrievedProduct = repo.fetch(product.getName());

        assertTrue(product.equals(retrievedProduct));
    }

    @Test
    public void fetchByNameRetursNullWhenProductNotInRepo() {
        Product retrievedProduct = repo.fetch("non-existent-product");

        assertNull(retrievedProduct);
    }

    @Test
    public void deleteRemovesProductFromRepo() {
        repo.save(product);
        repo.delete(product);
        Product retrievedProduct = repo.fetch(product);

        assertNull(retrievedProduct);
    }
}
