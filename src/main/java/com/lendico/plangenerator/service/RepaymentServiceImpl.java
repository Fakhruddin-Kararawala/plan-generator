package com.lendico.plangenerator.service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lendico.plangenerator.model.Repayment;
import com.lendico.plangenerator.model.RepaymentPlan;
import com.lendico.plangenerator.model.RepaymentPlanRequest;


/**
 * The Class RepaymentServiceImpl.
 */
@Service
public class RepaymentServiceImpl implements RepaymentService {

  /** The repayment calculator. */
  @Autowired
  private RepaymentCalculatorService repaymentCalculator;

  /**
   * Instantiates a new repayment service impl.
   */
  public RepaymentServiceImpl() {}

  public RepaymentServiceImpl(RepaymentCalculatorService repaymentCalculator) {
    this.repaymentCalculator = repaymentCalculator;
  }

  /**
   * Generate plan.
   *
   * @param request the request
   * @return the repayment plan
   */
  @Override
  public RepaymentPlan generatePlan(RepaymentPlanRequest request) {

    BigDecimal loanAmount = request.getLoanAmount();
    Double nominalRate = request.getNominalRate();
    Integer duration = request.getDuration();

    Date startDate = request.getStartDate();
    Instant instant = startDate.toInstant();
    ZoneId zone = ZoneId.systemDefault();
    LocalDateTime localStartDate = LocalDateTime.ofInstant(instant, zone);

    List<Repayment> repayments = new ArrayList<>();
    BigDecimal initialOutstandingPrincipal = loanAmount;

    /* Fulfill the repayment plan with monthly calculations. */
    for (int i = 0; i < duration; i++) {
      Repayment repayment = this.generateRepayment(loanAmount, nominalRate, duration,
          localStartDate, initialOutstandingPrincipal, i);

      /* Rerolls the initial outstanding principal for the next month. */
      BigDecimal remainingOutstandingPrincipal = repayment.getRemainingOutstandingPrincipal();
      initialOutstandingPrincipal = remainingOutstandingPrincipal;

      repayments.add(repayment);
    }

    RepaymentPlan plan = new RepaymentPlan();
    plan.setRepayments(repayments);

    return plan;
  }

  /**
   * Generate repayment.
   *
   * @param loanAmount the loan amount
   * @param nominalRate the nominal rate
   * @param duration the duration
   * @param startDate the start date
   * @param initialOutstandingPrincipal the initial outstanding principal
   * @param monthsAfterStart the months after start
   * @return the repayment
   */
  @Override
  public Repayment generateRepayment(BigDecimal loanAmount, double nominalRate, int duration,
      LocalDateTime startDate, BigDecimal initialOutstandingPrincipal, int monthsAfterStart) {

    Repayment repayment = new Repayment();

    /* Date. */
    LocalDateTime date = startDate.plusMonths(monthsAfterStart);
    repayment.setDate(date);

    /* Interest. */
    BigDecimal interest =
        repaymentCalculator.calculateInterest(nominalRate, initialOutstandingPrincipal);
    repayment.setInterest(interest);

    /* Annuity. */
    BigDecimal annuity = repaymentCalculator.calculateAnnuity(loanAmount, nominalRate, duration);
    repayment.setBorrowerPaymentAmount(annuity);

    /* Principal. */
    BigDecimal principal = repaymentCalculator.calculatePrincipal(interest, annuity);
    repayment.setPrincipal(principal);

    /* Initial outstanding principal. */
    repayment.setInitialOutstandingPrincipal(initialOutstandingPrincipal);

    /* Remaining outstanding principal. */
    BigDecimal remainingOutstandingPrincipal = repaymentCalculator
        .calculateRemainingOutstandingPrincipal(initialOutstandingPrincipal, principal);
    repayment.setRemainingOutstandingPrincipal(remainingOutstandingPrincipal);

    return repayment;
  }
}
