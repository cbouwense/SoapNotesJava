package com.thelathereddragon.entities;

public class Amount {
  private double value;
  private UnitOfMeasurement unit;

  public Amount(double value, UnitOfMeasurement unit) {
    this.value = value;
    this.unit = unit;
  }

  public Amount asGrams() {
    return new Amount(value * unit.getGramsPerUnit(), UnitOfMeasurement.GRAM);
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
}
