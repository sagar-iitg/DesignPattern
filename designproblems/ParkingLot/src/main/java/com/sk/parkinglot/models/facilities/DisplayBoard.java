package com.sk.parkinglot.models.facilities;

import com.sk.parkinglot.interfaces.IParkingSpot;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayBoard {
  private int id;
  private Map<String, List<IParkingSpot>> parkingSpots;

  // constructor
  public DisplayBoard(int id) {
    this.id = id;
    parkingSpots = new HashMap<>();
  }

  // functions
  public void showFree() {}

  public void sendParkingFullNotification() {}

  public void addParkingSlot(String spotType, List<IParkingSpot> spots) {
    // add your own impl here
  }
}
