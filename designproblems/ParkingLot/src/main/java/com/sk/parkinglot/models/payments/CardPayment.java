package com.sk.parkinglot.models.payments;

import com.sk.parkinglot.interfaces.IPayment;

public class CardPayment extends IPayment {
  @Override
  public boolean initiateTransaction() {
    // add your own impl here
    return false;
  }
}
