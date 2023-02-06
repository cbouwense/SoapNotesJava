package com.thelathereddragon;

import static spark.Spark.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thelathereddragon.entities.Product;
import com.thelathereddragon.ports.ProductRepo;
import com.thelathereddragon.repos.JsonProductRepo;
import com.thelathereddragon.usecases.GetProductByName;

public class Main {
    public static void main(String[] args) {
        ProductRepo productRepo = new JsonProductRepo(new GsonBuilder().setPrettyPrinting().create());
        GetProductByName getProduct = new GetProductByName(productRepo);

        get("/products/:name", (req, res) -> {
            res.type("application/json");
            Product p = getProduct.execute(req.params(":name"));
            return p == null ? "{}" : new GsonBuilder().create().toJson(p);
        });

        post("/products", (req, res) -> {
            res.type("application/json");
            Product p = new Gson().fromJson(req.body(), Product.class);
            productRepo.save(p);
            
            Product savedProduct = productRepo.fetch(p.getName());
            return new GsonBuilder().create().toJson(savedProduct);
        });
    }
}