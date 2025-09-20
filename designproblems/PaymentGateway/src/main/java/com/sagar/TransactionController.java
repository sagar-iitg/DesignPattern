package com.sagar;

import java.util.List;

public class TransactionController {
    TransactionService txnService;

    public TransactionController() {
        txnService = new TransactionService();
    }

    public TransactionDO makePayment(TransactionDO txnDO) {
        return txnService.makePayment(txnDO);
    }

    public List<Transaction> getTransactionHistory(int userID) {
        return txnService.getTransactionHistory(userID);
    }

    public static class Processor {
        public boolean processPayment(InstrumentDO senderInstrument, InstrumentDO receiverInstrument) {
            // Here you can place logic like balance checks, etc.
            // For demo, we accept all payments as successful.
            System.out.println("Processing payment from InstrumentID:" + senderInstrument.getInstrumentID() +
                    " to InstrumentID:" + receiverInstrument.getInstrumentID());
            return true;
        }
    }
}
