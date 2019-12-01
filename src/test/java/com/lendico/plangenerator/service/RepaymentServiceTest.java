package com.lendico.plangenerator.service;

import static org.mockito.Mockito.mock;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.lendico.plangenerator.model.Repayment;
import com.lendico.plangenerator.model.RepaymentPlan;
import com.lendico.plangenerator.model.RepaymentPlanRequest;

/**
 * The Class RepaymentServiceTest.
 */
@SpringBootTest
public class RepaymentServiceTest {

  /** The service. */
  private RepaymentService service;

  /** The calculator service. */
  private RepaymentCalculatorService calculatorService;

  /** The request. */
  private RepaymentPlanRequest request;

  /**
   * Sets the up.
   */
  @Before
  public void setUp() {
    request = new RepaymentPlanRequest();
    request.setLoanAmount(new BigDecimal(5000.0));
    request.setNominalRate(5.0);
    request.setDuration(24);
    request.setStartDate(new Date());
    this.calculatorService = mock(RepaymentCalculatorServiceImpl.class);
    this.service = new RepaymentServiceImpl(calculatorService);
  }

  /**
   * Test generate plan.
   */
  @Test
  public void testGeneratePlan() {
    RepaymentPlan plan = service.generatePlan(request);
    Assert.assertNotNull(plan);

    List<Repayment> repayments = plan.getRepayments();
    Assert.assertEquals(request.getDuration().intValue(), repayments.size());
  }

  /**
   * Test generate repayment.
   */
  @Test
  public void testGenerateRepayment() {
    BigDecimal loanAmount = new BigDecimal(5000.0);
    Double nominalRate = 5.0;
    int duration = 24;
    LocalDateTime startDate = LocalDateTime.of(2018, 1, 1, 0, 0, 1);
    BigDecimal initialOutstandingPrincipal = new BigDecimal(5000);
    int monthsAfterStart = 0;

    Repayment repayment = service.generateRepayment(loanAmount, nominalRate, duration, startDate,
        initialOutstandingPrincipal, monthsAfterStart);
    Assert.assertNotNull(repayment);
  }

}
