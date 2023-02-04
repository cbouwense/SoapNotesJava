package com.thelathereddragon.entities;

public enum UnitOfMeasurement {
  GRAM,
  KILOGRAM,
  OUNCE,
  POUND,
  MILLILITER,
  TEASPOON,
  TABLESPOON;

  public double getGramsPerUnit() {
    switch (this) {
      case GRAM:
        return 1;
      case KILOGRAM:
        return 1000;
      case OUNCE:
        return 28.3495;
      case POUND:
        return 453.592;
      case MILLILITER:
        return 1;
      case TEASPOON:
        return 4.92892;
      case TABLESPOON:
        return 14.7868;
      default:
        return 0;
    }
  }
}
