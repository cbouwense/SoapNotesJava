package com.thelathereddragon.repos;

import static com.thelathereddragon.entities.UnitOfMeasurement.OUNCES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thelathereddragon.entities.Amount;
import com.thelathereddragon.entities.Product;

public class JsonProductRepoTest {
    Product product;
    String fileName;
    private Gson gson;
    private JsonProductRepo repo;

    @Before
    public void beforeEach() {
        product = new Product(
            "test-product-2",
            "This is a test product",
            1000,
            new Amount(51, OUNCES)
        );
        gson = new GsonBuilder().setPrettyPrinting().create();
        repo = new JsonProductRepo(gson);
    }

    @Test
    public void saveCreatesFileInFilesystem() {
        repo.save(product);

        File f = new File(product.getName() + ".json");
        assertTrue(f.isFile());
    }

    @Test
    public void saveCreatesFileWithCorrectJson() throws IOException {
        repo.save(product);

        Reader reader = Files.newBufferedReader(Paths.get(product.getName() + ".json"));
        Product retrievedProduct = gson.fromJson(reader, Product.class);
        
        assertEquals(product.getName(), retrievedProduct.getName());
        assertEquals(product.getDescription(), retrievedProduct.getDescription());
        assertEquals(product.getPriceInCents(), retrievedProduct.getPriceInCents());
        assertEquals(product.getNetWeight().getUnit(), retrievedProduct.getNetWeight().getUnit());
        assertEquals(product.getNetWeight().getValue(), retrievedProduct.getNetWeight().getValue(), 0.0);
    }
}
