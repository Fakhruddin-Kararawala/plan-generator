package com.lendico.plangenerator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;


/**
 * The Class RepaymentCalculatorServiceImpl.
 */
@Service
public class RepaymentCalculatorServiceImpl implements RepaymentCalculatorService {

  /**
   * Calculate remaining outstanding principal.
   *
   * @param initialOutstandingPrincipal the initial outstanding principal
   * @param principal the principal
   * @return the big decimal
   */
  @Override
  public BigDecimal calculateRemainingOutstandingPrincipal(BigDecimal initialOutstandingPrincipal,
      BigDecimal principal) {

    /* Calculates the remaining outstanding principal. */
    BigDecimal remainingOutstandingPrincipal = initialOutstandingPrincipal.subtract(principal);

    /* Since the value cannot be negative, it is set to zero instead. */
    if (remainingOutstandingPrincipal.compareTo(BigDecimal.ZERO) < 0) {
      remainingOutstandingPrincipal = BigDecimal.ZERO.setScale(2);
    }

    return remainingOutstandingPrincipal;
  }

  /**
   * Calculate principal.
   *
   * @param interest the interest
   * @param annuity the annuity
   * @return the big decimal
   */
  @Override
  public BigDecimal calculatePrincipal(BigDecimal interest, BigDecimal annuity) {

    BigDecimal principal = annuity.subtract(interest);

    return principal.setScale(2, RoundingMode.HALF_EVEN);
  }

  /**
   * Calculate interest.
   *
   * @param nominalRate the nominal rate
   * @param initialOutstandingPrincipal the initial outstanding principal
   * @return the big decimal
   */
  @Override
  public BigDecimal calculateInterest(double nominalRate, BigDecimal initialOutstandingPrincipal) {

    /* Calculates the interest. */
    BigDecimal interest =
        new BigDecimal(nominalRate / 100 * 30 * initialOutstandingPrincipal.doubleValue() / 360);

    return interest.setScale(2, RoundingMode.HALF_EVEN);

  }

  /**
   * Calculate annuity.
   *
   * @param loanAmount the loan amount
   * @param nominalRate the nominal rate
   * @param duration the duration
   * @return the big decimal
   */
  @Override
  public BigDecimal calculateAnnuity(BigDecimal loanAmount, double nominalRate, int duration) {
    /* Normalise the rate as a percentage. */
    nominalRate = nominalRate / 100.0;

    /* Divide the nominal rate by the number of months in a year. */
    double nominalRateByMonth = nominalRate / 12.0;

    /* Calculates the annuity as per formula. */
    double annuity = (loanAmount.doubleValue() * nominalRateByMonth)
        / (1 - Math.pow(1 + nominalRateByMonth, -duration));

    /* roundoff the result. */
    BigDecimal result = new BigDecimal(annuity);

    return result.setScale(2, RoundingMode.HALF_EVEN);

  }
}
