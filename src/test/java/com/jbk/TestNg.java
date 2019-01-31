package com.jbk;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNg {
  @Test
  public void TC01() {
	  Assert.assertEquals(4, 4);
  }
  @Test
  public void TC02()
  {
	  Assert.assertEquals(5, 5);
  }
}
