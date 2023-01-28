package com.thelathereddragon.usecases;

import org.junit.Test;

import com.thelathereddragon.entities.Product;

public class CreateProductTest {
    @Test
    public void createProduct() {
        CreateProduct createProduct = new CreateProduct();
        Product product = createProduct.createProduct();
    }
}