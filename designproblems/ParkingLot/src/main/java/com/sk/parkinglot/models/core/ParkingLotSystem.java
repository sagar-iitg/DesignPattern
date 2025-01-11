package com.sk.parkinglot.models.core;

import com.sk.parkinglot.interfaces.IParkingSpot;
import com.sk.parkinglot.interfaces.IVehicle;
import com.sk.parkinglot.models.*;
import com.sk.parkinglot.models.facilities.DisplayBoard;
import com.sk.parkinglot.models.facilities.Entrance;
import com.sk.parkinglot.models.facilities.Exit;
import java.util.Map;

public class ParkingLotSystem {
  private int id;
  private String name;
  private String address;
  private final int MAX_CAPACTIY = 40000;
  private Map<String, Entrance> entrances;
  private Map<String, Exit> exits;
  private ParkingRate parkingRate;
  private Map<String, DisplayBoard> displayBoards;
  private Map<String, ParkingTicket> parkingTickets;
  private Map<String, IParkingSpot> parkingSpots;

  // instance
  private static ParkingLotSystem parkingLot = null;

  // singleton design pattern
  private ParkingLotSystem() {
    // add your impl here
  }

  // getInstance
  public static ParkingLotSystem getInstance() {
    // TODO: will this work in multi-threaded env
    if (parkingLot == null) {
      parkingLot = new ParkingLotSystem();
    }
    return parkingLot;
  }

  public ParkingTicket getParkingTicket(IVehicle vehicle) {
    // add your impl here
    return null;
  }

  public boolean isFull() {
    // add ur logic here
    return false;
  }

  public boolean addEntrance(Entrance entrance) {
    return false;
  }

  public boolean addExit(Exit exit) {
    return false;
  }
  // add more methods here

}
