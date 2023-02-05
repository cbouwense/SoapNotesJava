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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + priceInCents;
    result = prime * result + ((netWeight == null) ? 0 : netWeight.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (description == null) {
      if (other.description != null)
        return false;
    } else if (!description.equals(other.description))
      return false;
    if (priceInCents != other.priceInCents)
      return false;
    if (netWeight == null) {
      if (other.netWeight != null)
        return false;
    } else if (!netWeight.equals(other.netWeight))
      return false;
    return true;
  }
}
