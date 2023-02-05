package com.thelathereddragon.repos;

import static com.thelathereddragon.entities.UnitOfMeasurement.OUNCES;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thelathereddragon.entities.Amount;
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
