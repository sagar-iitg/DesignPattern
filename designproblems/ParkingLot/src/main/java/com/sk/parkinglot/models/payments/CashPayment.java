package com.sk.parkinglot.models.payments;

import com.sk.parkinglot.interfaces.IPayment;

public class CashPayment extends IPayment {

  @Override
  public boolean initiateTransaction() {
    // add your orwn implementaion here
    return false;
  }
}
