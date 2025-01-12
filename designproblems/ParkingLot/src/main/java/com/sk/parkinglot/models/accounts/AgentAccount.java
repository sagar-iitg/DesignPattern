package com.sk.parkinglot.models.accounts;

import com.sk.parkinglot.interfaces.IAccount;
import com.sk.parkinglot.models.core.ParkingTicket;

public class AgentAccount extends IAccount {

  public boolean processTicket(ParkingTicket ticket) {
    return false;
  }

  @Override
  public boolean resetPassword() {
    // add your own impl here
    return false;
  }
}
