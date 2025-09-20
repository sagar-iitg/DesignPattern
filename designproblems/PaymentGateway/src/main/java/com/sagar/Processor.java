package com.sagar;

public class Processor {
    public boolean processPayment(InstrumentDO senderInstrument, InstrumentDO receiverInstrument) {
        // Here you can place logic like balance checks, etc.
        // For demo, we accept all payments as successful.
        System.out.println("Processing payment from InstrumentID:" + senderInstrument.getInstrumentID() +
                " to InstrumentID:" + receiverInstrument.getInstrumentID());
        return true;
    }
}
