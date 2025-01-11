package com.sk.parkinglot.models.spot;

import com.sk.parkinglot.interfaces.IParkingSpot;

public class Large extends IParkingSpot {
  @Override
  public boolean getIsFree() {
    // add your own implementation here
    return false;
  }
}
