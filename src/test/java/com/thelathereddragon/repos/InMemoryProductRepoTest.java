package com.thelathereddragon.repos;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.thelathereddragon.entities.Product;

public class InMemoryProductRepoTest {
  private InMemoryProductRepo repo;

  @Before
  public void setup() {
    repo = new InMemoryProductRepo();
  }

  @Test
  public void startsOutAsEmpty() {
    assertEquals(0, repo.size());
  }

  @Test
  public void savingOnceCreatesSizeOfOne() {
    repo.save(new Product());

    assertEquals(1, repo.size());
  }

  @Test
  public void savingTwiceCreatesSizeOfTwo() {
    repo.save(new Product());
    repo.save(new Product());

    assertEquals(2, repo.size());
  }

  @Test
  public void savingTwiceAndDeletingOnceCreatesSizeOfOne() {
    Product product = new Product();

    repo.save(product);
    repo.save(new Product());
    repo.delete(product);

    assertEquals(1, repo.size());
  }

  @Test
  public void savingTwiceAndDeletingTwiceCreatesSizeOfZero() {
    Product product1 = new Product();
    Product product2 = new Product();

    repo.save(product1);
    repo.save(product2);
    repo.delete(product1);
    repo.delete(product2);

    assertEquals(0, repo.size());
  }

  @Test
  public void deletingProductThatDoesNotExistDoesNotChangeSize() {
    repo.save(new Product());
    repo.delete(new Product());

    assertEquals(1, repo.size());
  }
}
