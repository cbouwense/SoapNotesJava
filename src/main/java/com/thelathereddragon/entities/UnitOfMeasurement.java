package com.thelathereddragon.entities;

public enum UnitOfMeasurement {
  GRAMS,
  KILOGRAMS,
  OUNCES,
  POUNDS,
  MILLILITERS,
  TEASPOONS,
  TABLESPOONS;

  public double getGramsPerUnit() {
    switch (this) {
      case GRAMS:
        return 1;
      case KILOGRAMS:
        return 1000;
      case OUNCES:
        return 28.3495;
      case POUNDS:
        return 453.592;
      case MILLILITERS:
        return 1;
      case TEASPOONS:
        return 4.92892;
      case TABLESPOONS:
        return 14.7868;
      default:
        return 0;
    }
  }
}
