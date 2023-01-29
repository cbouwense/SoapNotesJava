package com.thelathereddragon.entities;

public class Product {
  public int id;
  public String name;
  public String description;
  public int priceInCents;
  public Amount netWeight;

  public Product() {}

  public Product(int id, String name, String description, int priceInCents, Amount netWeight) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.priceInCents = priceInCents;
    this.netWeight = netWeight;
  }
}
