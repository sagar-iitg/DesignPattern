package com.sagar;

import java.util.*;

public class BankService extends InstrumentService {

    @Override
    public InstrumentDO addInstrument(InstrumentDO instrumentDO) {
        BankInstrument bankInstrument = new BankInstrument();
        bankInstrument.instrumentID = new Random().nextInt(90) + 10; // random between 10-99
        bankInstrument.bankAccountNumber = instrumentDO.getBankAccountNumber();
        bankInstrument.ifscCode = instrumentDO.getIfsc();
        bankInstrument.instrumentType = InstrumentType.BANK;
        bankInstrument.userID = instrumentDO.getUserID();

        List<Instrument> userInstrumentsList = userVsInstruments.get(bankInstrument.userID);
        if (userInstrumentsList == null) {
            userInstrumentsList = new ArrayList<>();
            userVsInstruments.put(bankInstrument.userID, userInstrumentsList);
        }
        userInstrumentsList.add(bankInstrument);

        return mapBankInstrumentToInstrumentDO(bankInstrument);
    }

    @Override
    public List<InstrumentDO> getInstrumentsByUserID(int userID) {
        List<Instrument> userInstruments = userVsInstruments.get(userID);
        List<InstrumentDO> userInstrumentsFetched = new ArrayList<>();
        if (userInstruments != null) {
            for (Instrument instrument : userInstruments) {
                if (instrument.getInstrumentType() == InstrumentType.BANK) {
                    userInstrumentsFetched.add(mapBankInstrumentToInstrumentDO((BankInstrument) instrument));
                }
            }
        }
        return userInstrumentsFetched;
    }

    public InstrumentDO mapBankInstrumentToInstrumentDO(BankInstrument bankInstrument) {
        InstrumentDO instrumentDOObj = new InstrumentDO();
        instrumentDOObj.setInstrumentType(bankInstrument.getInstrumentType());
        instrumentDOObj.setInstrumentID(bankInstrument.getInstrumentID());
        instrumentDOObj.setBankAccountNumber(bankInstrument.bankAccountNumber);
        instrumentDOObj.setIfsc(bankInstrument.ifscCode);
        instrumentDOObj.setUserID(bankInstrument.userID);
        return instrumentDOObj;
    }
}
