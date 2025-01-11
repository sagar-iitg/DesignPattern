package com.sk.parkinglot.models.accounts;

import com.sk.parkinglot.interfaces.IAccount;
import com.sk.parkinglot.interfaces.IParkingSpot;
import com.sk.parkinglot.models.facilities.DisplayBoard;
import com.sk.parkinglot.models.facilities.Entrance;
import com.sk.parkinglot.models.facilities.Exit;

public class AdminAccount extends IAccount {

  // khud ki kuch poperties bhi hongi vo add kardo
  public boolean addParkingSpot(IParkingSpot spot) {
    // add your impl here
    return false;
  }

  public boolean addEntrance(Entrance entry) {
    // add your impl here
    return false;
  }

  public boolean addExit(Exit exit) {
    // add your impl here
    return false;
  }

  public boolean addDisplayBoard(DisplayBoard board) {
    // add your impl here
    return false;
  }

  @Override
  public boolean resetPassword() {
    // add your own impl here
    return false;
  }
}
