package com.thelathereddragon.repos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.thelathereddragon.entities.Product;
import com.thelathereddragon.ports.ProductRepo;

public class JsonProductRepo implements ProductRepo {
    // TODO: I feel like this could be some kind of JsonBuilder class or interface. 
    private Gson jsonBuilder;

    JsonProductRepo(Gson jsonBuilder) {
        this.jsonBuilder = jsonBuilder;
    }

    @Override
    public void save(Product product) {
        try {
            FileWriter writer = new FileWriter(product.getName() + ".json");
            jsonBuilder.toJson(product, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }      
    }

    @Override
    public Product fetch(Product product) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(product.getName() + ".json"));
            return jsonBuilder.fromJson(reader, Product.class);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(Product product) {
        File f = new File(product.getName() + ".json");
        f.delete();
    }

    @Override
    public Product fetch(String name) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(name + ".json"));
            return jsonBuilder.fromJson(reader, Product.class);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
    
}
