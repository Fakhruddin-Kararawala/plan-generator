package com.lendico.plangenerator.service;

import java.math.BigDecimal;


/**
 * The Interface RepaymentCalculatorService.
 */
public interface RepaymentCalculatorService {

  /**
   * Given the values of the initial outstanding principal and the principal, calculates the
   * remaining outstanding principal.
   * 
   * @param initialOutstandingPrincipal The initial outstanding principal value
   * @param principal The principal value
   * @return The resulting remaining outstanding principal value
   */
  BigDecimal calculateRemainingOutstandingPrincipal(BigDecimal initialOutstandingPrincipal,
      BigDecimal principal);

  /**
   * Given an interest calculated value and an annuity, calculates the principal value.
   * 
   * @param interest The interest calculated value
   * @param annuity The annuity value
   * @return The resulting principal value
   */
  BigDecimal calculatePrincipal(BigDecimal interest, BigDecimal annuity);

  /**
   * Given the nominal interest rate and the initial outstanding principal value, calculates the
   * interest value.
   * 
   * @param nominalRate The nominal interest rate
   * @param initialOutstandingPrincipal The initial outstanding principal value
   * @return The resulting interest value
   */
  BigDecimal calculateInterest(double nominalRate, BigDecimal initialOutstandingPrincipal);

  /**
   * Calculate annuity.
   *
   * @param loanAmount the loan amount
   * @param nominalRate the nominal rate
   * @param duration the duration
   * @return the big decimal
   */
  BigDecimal calculateAnnuity(BigDecimal loanAmount, double nominalRate, int duration);
}
