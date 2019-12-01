package com.lendico.plangenerator.service;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The Class RepaymentCalculatorServiceTest.
 */
@SpringBootTest
public class RepaymentCalculatorServiceTest {

  /** The calculator. */
  @Autowired
  private RepaymentCalculatorService calculator;

  /**
   * Test calculate remaining outstanding principal.
   */
  @Test
  public void testCalculateRemainingOutstandingPrincipal() {
    BigDecimal initialOutstandingPrincipal = new BigDecimal(5000);
    BigDecimal principal = new BigDecimal(198.53);

    BigDecimal remainingOutstandingPrincipal =
        calculator.calculateRemainingOutstandingPrincipal(initialOutstandingPrincipal, principal);
    Assert.assertEquals(4801.47, remainingOutstandingPrincipal.doubleValue(), 0);
  }

  /**
   * Test calculate principal.
   */
  @Test
  public void testCalculatePrincipal() {
    BigDecimal interest = new BigDecimal(20.83);
    BigDecimal annuity = new BigDecimal(219.36);

    BigDecimal principal = calculator.calculatePrincipal(interest, annuity);
    Assert.assertEquals(198.53, principal.doubleValue(), 0);
  }

  /**
   * Test calculate interest.
   */
  @Test
  public void testCalculateInterest() {
    double nominalRate = 5.0;
    BigDecimal initialOutstandingPrincipal = new BigDecimal(5000);

    BigDecimal interest = calculator.calculateInterest(nominalRate, initialOutstandingPrincipal);
    Assert.assertEquals(20.83, interest.doubleValue(), 0);

  }

  /**
   * Test calculate annuity.
   */
  @Test
  public void testCalculateAnnuity() {
    BigDecimal loanAmount = new BigDecimal(5000);
    double nominalRate = 5.0;
    int duration = 24;

    BigDecimal annuity = calculator.calculateAnnuity(loanAmount, nominalRate, duration);
    Assert.assertEquals(219.36, annuity.doubleValue(), 0);

  }

}
