package com.lendico.plangenerator.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.lendico.plangenerator.model.Repayment;
import com.lendico.plangenerator.model.RepaymentPlan;
import com.lendico.plangenerator.model.RepaymentPlanRequest;


/**
 * The Interface RepaymentService.
 */
public interface RepaymentService {

  /**
   * @param loanAmount The amount of the loan
   * @param nominalRate The nominal interest rate
   * @param duration The duration in months of the loan
   * @param startDate The starting date of the loan
   * @param initialOutstandingPrincipal The initial outstanding principal value
   * @param monthsAfterStart The number of months after the start date
   * @return The resulting repayment for the given input values
   */
  Repayment generateRepayment(BigDecimal loanAmount, double nominalRate, int duration,
      LocalDateTime startDate, BigDecimal initialOutstandingPrincipal, int monthsAfterStart);

  /**
   * Generate plan.
   *
   * @param request the request
   * @return the repayment plan
   */
  RepaymentPlan generatePlan(RepaymentPlanRequest request);
}
