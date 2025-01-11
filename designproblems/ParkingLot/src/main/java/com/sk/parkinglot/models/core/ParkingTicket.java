package com.sk.parkinglot.models.core;

import com.sk.parkinglot.interfaces.IPayment;
import com.sk.parkinglot.interfaces.IVehicle;
import com.sk.parkinglot.models.facilities.Entrance;
import com.sk.parkinglot.models.facilities.Exit;
import java.util.Date;

public class ParkingTicket {
  private int ticketNo;
  private Date extryTimestamp;
  private Date exitTimestamp;
  private double amount;
  private boolean status;

  /// iske alawa or k k chahoye hoga
  private IVehicle vehicle;
  private IPayment payment;
  private Entrance entrance;
  private Exit exit;
}
