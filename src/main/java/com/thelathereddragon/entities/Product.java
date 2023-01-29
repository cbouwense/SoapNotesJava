package com.thelathereddragon.entities;

import static com.thelathereddragon.entities.UnitOfMeasurement.GRAM;

public class Product {
  public final int id;
  public final String name;
  public final String description;
  public final int priceInCents;
  public final Amount netWeight;

  public Product() {
    this.id = 0;
    this.name = "";
    this.description = "";
    this.priceInCents = 0;
    this.netWeight = new Amount(0, GRAM);
  }

  public Product(int id, String name, String description, int priceInCents, Amount netWeight) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.priceInCents = priceInCents;
    this.netWeight = netWeight;
  }
}
