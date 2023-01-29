package com.thelathereddragon.entities;

public class Amount {
  public float value;
  public UnitOfMeasurement unit;

  public Amount(float value, UnitOfMeasurement unit) {
    this.value = value;
    this.unit = unit;
  }
}
