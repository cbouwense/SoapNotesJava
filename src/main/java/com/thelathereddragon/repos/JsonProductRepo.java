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

    public JsonProductRepo(Gson jsonBuilder) {
        this.jsonBuilder = jsonBuilder;
    }

    @Override
    public void save(Product product) {
        try {
            FileWriter writer = new FileWriter(pathFromProduct(product));
            jsonBuilder.toJson(product, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving product to repository.");
            e.printStackTrace();
        }      
    }

    @Override
    public Product fetch(Product product) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(pathFromProduct(product)));
            return jsonBuilder.fromJson(reader, Product.class);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(Product product) {
        File f = new File(pathFromProduct(product));
        f.delete();
    }

    @Override
    public Product fetch(String name) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(pathFromName(name)));
            return jsonBuilder.fromJson(reader, Product.class);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    private String pathFromProduct(Product product) {
        return Constants.productsDirectory + product.getName() + ".json";
    }

    private String pathFromName(String name) {
        return Constants.productsDirectory + name + ".json";
    }
    
}
