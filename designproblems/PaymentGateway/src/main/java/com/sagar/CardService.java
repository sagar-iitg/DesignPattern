package com.sagar;

import java.util.*;

public class CardService extends InstrumentService {

    @Override
    public InstrumentDO addInstrument(InstrumentDO instrumentDO) {
        CardInstrument cardInstrument = new CardInstrument();
        cardInstrument.instrumentID = new Random().nextInt(90) + 10; // random between 10-99
        cardInstrument.cardNumber = instrumentDO.getCardNumber();
        cardInstrument.cvvNumber = instrumentDO.getCvv();
        cardInstrument.instrumentType = InstrumentType.CARD;
        cardInstrument.userID = instrumentDO.getUserID();

        List<Instrument> userInstrumentsList = userVsInstruments.get(cardInstrument.userID);
        if (userInstrumentsList == null) {
            userInstrumentsList = new ArrayList<>();
            userVsInstruments.put(cardInstrument.userID, userInstrumentsList);
        }
        userInstrumentsList.add(cardInstrument);

        return mapBankInstrumentToInstrumentDO(cardInstrument);
    }

    @Override
    public List<InstrumentDO> getInstrumentsByUserID(int userID) {
        List<Instrument> userInstruments = userVsInstruments.get(userID);
        List<InstrumentDO> userInstrumentsFetched = new ArrayList<>();
        if (userInstruments != null) {
            for (Instrument instrument : userInstruments) {
                if (instrument.getInstrumentType() == InstrumentType.CARD) {
                    userInstrumentsFetched.add(mapBankInstrumentToInstrumentDO((CardInstrument) instrument));
                }
            }
        }
        return userInstrumentsFetched;
    }

    public InstrumentDO mapBankInstrumentToInstrumentDO(CardInstrument cardInstrument) {
        InstrumentDO instrumentDOObj = new InstrumentDO();
        instrumentDOObj.setInstrumentType(cardInstrument.getInstrumentType());
        instrumentDOObj.setInstrumentID(cardInstrument.getInstrumentID());
        instrumentDOObj.setCardNumber(cardInstrument.cardNumber);
        instrumentDOObj.setCvv(cardInstrument.cvvNumber);
        instrumentDOObj.setUserID(cardInstrument.getUserID());
        return instrumentDOObj;
    }
}
