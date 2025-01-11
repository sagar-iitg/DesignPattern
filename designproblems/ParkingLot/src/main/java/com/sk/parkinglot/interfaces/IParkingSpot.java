package com.sk.parkinglot.interfaces;

public abstract class IParkingSpot {
  private int id;
  private boolean isFree;
  private IVehicle vehicle;

  public abstract boolean getIsFree();
}
