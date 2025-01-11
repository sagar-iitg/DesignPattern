package com.sk.parkinglot.interfaces;

import com.sk.parkinglot.constants.PaymentStatus;
import java.util.Date;

public abstract class IPayment {
  private double amount;
  private PaymentStatus status;
  private Date timestamp;
  private String transactionID;

  public abstract boolean initiateTransaction();
}
