package com.sk.parkinglot.models.spot;

import com.sk.parkinglot.interfaces.IParkingSpot;

public class Handicapped extends IParkingSpot {

  @Override
  public boolean getIsFree() {
    /// implement
    return false;
  }
}
