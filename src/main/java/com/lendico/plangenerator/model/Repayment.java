package com.lendico.plangenerator.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * The Class Repayment.
 */
public class Repayment {

  /** The borrower payment amount. */
  private BigDecimal borrowerPaymentAmount;

  /** The date. */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  private LocalDateTime date;

  /** The initial outstanding principal. */
  private BigDecimal initialOutstandingPrincipal;

  /** The interest. */
  private BigDecimal interest;

  /** The principal. */
  private BigDecimal principal;

  /** The remaining outstanding principal. */
  private BigDecimal remainingOutstandingPrincipal;

  /**
   * Gets the borrower payment amount.
   *
   * @return the borrower payment amount
   */
  public BigDecimal getBorrowerPaymentAmount() {
    return borrowerPaymentAmount;
  }

  /**
   * Sets the borrower payment amount.
   *
   * @param borrowerPaymentAmount the new borrower payment amount
   */
  public void setBorrowerPaymentAmount(BigDecimal borrowerPaymentAmount) {
    this.borrowerPaymentAmount = borrowerPaymentAmount;
  }

  /**
   * Gets the date.
   *
   * @return the date
   */
  public LocalDateTime getDate() {
    return date;
  }

  /**
   * Sets the date.
   *
   * @param date the new date
   */
  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  /**
   * Gets the initial outstanding principal.
   *
   * @return the initial outstanding principal
   */
  public BigDecimal getInitialOutstandingPrincipal() {
    return initialOutstandingPrincipal;
  }

  /**
   * Sets the initial outstanding principal.
   *
   * @param initialOutstandingPrincipal the new initial outstanding principal
   */
  public void setInitialOutstandingPrincipal(BigDecimal initialOutstandingPrincipal) {
    this.initialOutstandingPrincipal = initialOutstandingPrincipal;
  }

  /**
   * Gets the interest.
   *
   * @return the interest
   */
  public BigDecimal getInterest() {
    return interest;
  }

  /**
   * Sets the interest.
   *
   * @param interest the new interest
   */
  public void setInterest(BigDecimal interest) {
    this.interest = interest;
  }

  /**
   * Gets the principal.
   *
   * @return the principal
   */
  public BigDecimal getPrincipal() {
    return principal;
  }

  /**
   * Sets the principal.
   *
   * @param principal the new principal
   */
  public void setPrincipal(BigDecimal principal) {
    this.principal = principal;
  }

  /**
   * Gets the remaining outstanding principal.
   *
   * @return the remaining outstanding principal
   */
  public BigDecimal getRemainingOutstandingPrincipal() {
    return remainingOutstandingPrincipal;
  }

  /**
   * Sets the remaining outstanding principal.
   *
   * @param remainingOutstandingPrincipal the new remaining outstanding principal
   */
  public void setRemainingOutstandingPrincipal(BigDecimal remainingOutstandingPrincipal) {
    this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
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
    result =
        prime * result + ((borrowerPaymentAmount == null) ? 0 : borrowerPaymentAmount.hashCode());
    result = prime * result + ((date == null) ? 0 : date.hashCode());
    result = prime * result
        + ((initialOutstandingPrincipal == null) ? 0 : initialOutstandingPrincipal.hashCode());
    result = prime * result + ((interest == null) ? 0 : interest.hashCode());
    result = prime * result + ((principal == null) ? 0 : principal.hashCode());
    result = prime * result
        + ((remainingOutstandingPrincipal == null) ? 0 : remainingOutstandingPrincipal.hashCode());
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
    Repayment other = (Repayment) obj;
    if (borrowerPaymentAmount == null) {
      if (other.borrowerPaymentAmount != null)
        return false;
    } else if (!borrowerPaymentAmount.equals(other.borrowerPaymentAmount))
      return false;
    if (date == null) {
      if (other.date != null)
        return false;
    } else if (!date.equals(other.date))
      return false;
    if (initialOutstandingPrincipal == null) {
      if (other.initialOutstandingPrincipal != null)
        return false;
    } else if (!initialOutstandingPrincipal.equals(other.initialOutstandingPrincipal))
      return false;
    if (interest == null) {
      if (other.interest != null)
        return false;
    } else if (!interest.equals(other.interest))
      return false;
    if (principal == null) {
      if (other.principal != null)
        return false;
    } else if (!principal.equals(other.principal))
      return false;
    if (remainingOutstandingPrincipal == null) {
      if (other.remainingOutstandingPrincipal != null)
        return false;
    } else if (!remainingOutstandingPrincipal.equals(other.remainingOutstandingPrincipal))
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
    return "Repayment [borrowerPaymentAmount=" + borrowerPaymentAmount + ", date=" + date
        + ", initialOutstandingPrincipal=" + initialOutstandingPrincipal + ", interest=" + interest
        + ", principal=" + principal + ", remainingOutstandingPrincipal="
        + remainingOutstandingPrincipal + "]";
  }



}
