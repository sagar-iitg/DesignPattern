package com.sk.parkinglot.interfaces;

import com.sk.parkinglot.constants.AccountStatus;
import com.sk.parkinglot.models.Person;

public abstract class IAccount {
  private String username;
  private String pwd;
  private Person person;
  private AccountStatus status;

  public abstract boolean resetPassword();
}
