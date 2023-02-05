package com.thelathereddragon.repos;

import static com.thelathereddragon.entities.UnitOfMeasurement.OUNCES;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thelathereddragon.entities.Amount;
import com.thelathereddragon.entities.Product;
import com.thelathereddragon.ports.ProductRepo;

public class JsonProductRepo implements ProductRepo {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        Product p = new Product(
            "test-product",
            "This is a test product",
            1000,
            new Amount(51, OUNCES)
        );
        JsonProductRepo r = new JsonProductRepo();
        r.save(p);
    }

    @Override
    public void save(Product product) {
        try {
            FileWriter writer = new FileWriter(product.getName() + ".json");
            gson.toJson(product, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }      
    }

    @Override
    public Product fetch(Product product) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Product product) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Product fetch(String name) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
