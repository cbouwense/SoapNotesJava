package com.thelathereddragon.entities;

import static com.thelathereddragon.entities.UnitOfMeasurement.GRAMS;

public class Amount {
  private double value;
  private UnitOfMeasurement unit;

  public Amount(double value, UnitOfMeasurement unit) {
    this.value = value;
    this.unit = unit;
  }

  public Amount asGrams() {
    return new Amount(value * unit.getGramsPerUnit(), GRAMS);
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public UnitOfMeasurement getUnit() {
    return unit;
  }

  public void setUnit(UnitOfMeasurement unit) {
    this.unit = unit;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(value);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
    Amount other = (Amount) obj;
    if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
      return false;
    if (unit != other.unit)
      return false;
    return true;
  }
}
