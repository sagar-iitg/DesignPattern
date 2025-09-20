package com.sagar;

import java.util.*;

public abstract class InstrumentService {
    // Map of UserID to Instruments
    static Map<Integer, List<Instrument>> userVsInstruments = new HashMap<>();

    public abstract InstrumentDO addInstrument(InstrumentDO instrumentDO);

    public abstract List<InstrumentDO> getInstrumentsByUserID(int userID);
}
