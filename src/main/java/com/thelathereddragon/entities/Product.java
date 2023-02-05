package com.thelathereddragon.entities;

import static com.thelathereddragon.entities.UnitOfMeasurement.GRAMS;

public class Product {
  private String name;
  private String description;
  private int priceInCents;
  private Amount netWeight;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getPriceInCents() {
    return priceInCents;
  }

  public void setPriceInCents(int priceInCents) {
    this.priceInCents = priceInCents;
  }

  public Amount getNetWeight() {
    return netWeight;
  }

  public void setNetWeight(Amount netWeight) {
    this.netWeight = netWeight;
  }

  public Product() {
    this.name = "";
    this.description = "";
    this.priceInCents = 0;
    this.netWeight = new Amount(0, GRAMS);
  }

  public Product(String name, String description, int priceInCents, Amount netWeight) {
    this.name = name;
    this.description = description;
    this.priceInCents = priceInCents;
    this.netWeight = netWeight;
  }
}
