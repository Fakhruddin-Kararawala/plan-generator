package com.lendico.plangenerator.model;

import java.util.List;


/**
 * The Class RepaymentPlan.
 */
public class RepaymentPlan {

  /** The repayments. */
  private List<Repayment> repayments;


  /**
   * Gets the repayments.
   *
   * @return the repayments
   */
  public List<Repayment> getRepayments() {
    return repayments;
  }


  /**
   * Sets the repayments.
   *
   * @param repayments the new repayments
   */
  public void setRepayments(List<Repayment> repayments) {
    this.repayments = repayments;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[repayments=");
    builder.append(repayments);
    builder.append("]");
    return builder.toString();
  }
}
