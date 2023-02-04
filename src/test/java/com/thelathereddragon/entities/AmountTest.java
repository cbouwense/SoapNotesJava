package com.thelathereddragon.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AmountTest {
  @Test
  public void asGramsConvertsFromOunces() {
    Amount amount = new Amount(1, UnitOfMeasurement.OUNCES);
    Amount grams = amount.asGrams();
    
    assertEquals(28.3495, grams.getValue(), 0.0);
    assertEquals(UnitOfMeasurement.GRAMS, grams.getUnit());
  }
}
