package com.lendico.plangenerator.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * The Class RepaymentPlanRequest.
 */
public class RepaymentPlanRequest {

  /** The loan amount. */
  @NotNull(message = "loanAmount is Mandatory")
  private BigDecimal loanAmount;

  /** The nominal rate. */
  @NotNull(message = "nominalRate is Mandatory")
  private Double nominalRate;

  /** The duration. */
  @NotNull(message = "duration is Mandatory")
  private Integer duration;

  /** The start date. */
  @NotNull(message = "startDate is Mandatory")
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  private Date startDate;

  /**
   * Gets the loan amount.
   *
   * @return the loan amount
   */
  public BigDecimal getLoanAmount() {
    return loanAmount;
  }

  /**
   * Sets the loan amount.
   *
   * @param loanAmount the new loan amount
   */
  public void setLoanAmount(BigDecimal loanAmount) {
    this.loanAmount = loanAmount;
  }

  /**
   * Gets the nominal rate.
   *
   * @return the nominal rate
   */
  public Double getNominalRate() {
    return nominalRate;
  }

  /**
   * Sets the nominal rate.
   *
   * @param nominalRate the new nominal rate
   */
  public void setNominalRate(Double nominalRate) {
    this.nominalRate = nominalRate;
  }

  /**
   * Gets the duration.
   *
   * @return the duration
   */
  public Integer getDuration() {
    return duration;
  }

  /**
   * Sets the duration.
   *
   * @param duration the new duration
   */
  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  /**
   * Gets the start date.
   *
   * @return the start date
   */
  public Date getStartDate() {
    return startDate;
  }

  /**
   * Sets the start date.
   *
   * @param startDate the new start date
   */
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  /**
   * Hash code.
   *
   * @return the int
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((duration == null) ? 0 : duration.hashCode());
    result = prime * result + ((loanAmount == null) ? 0 : loanAmount.hashCode());
    result = prime * result + ((nominalRate == null) ? 0 : nominalRate.hashCode());
    result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
    return result;
  }

  /**
   * Equals.
   *
   * @param obj the obj
   * @return true, if successful
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    RepaymentPlanRequest other = (RepaymentPlanRequest) obj;
    if (duration == null) {
      if (other.duration != null)
        return false;
    } else if (!duration.equals(other.duration))
      return false;
    if (loanAmount == null) {
      if (other.loanAmount != null)
        return false;
    } else if (!loanAmount.equals(other.loanAmount))
      return false;
    if (nominalRate == null) {
      if (other.nominalRate != null)
        return false;
    } else if (!nominalRate.equals(other.nominalRate))
      return false;
    if (startDate == null) {
      if (other.startDate != null)
        return false;
    } else if (!startDate.equals(other.startDate))
      return false;
    return true;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "RepaymentPlanRequest [loanAmount=" + loanAmount + ", nominalRate=" + nominalRate
        + ", duration=" + duration + ", startDate=" + startDate + "]";
  }

}
