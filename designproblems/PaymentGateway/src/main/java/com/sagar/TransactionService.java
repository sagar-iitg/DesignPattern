package com.sagar;

import java.util.*;

public class TransactionService {
    public static Map<Integer, List<Transaction>> userVsTransactionsList = new HashMap<>();
    InstrumentController instrumentController;
    Processor processor;

    public TransactionService() {
        instrumentController = new InstrumentController();
        processor = new Processor();
    }

    public List<Transaction> getTransactionHistory(int userID) {
        return userVsTransactionsList.getOrDefault(userID, new ArrayList<>());
    }

    public TransactionDO makePayment(TransactionDO txnDO) {
        InstrumentDO senderInstrumentDO = instrumentController.getInstrumentByID(txnDO.getSenderId(), txnDO.getDebitInstrumentId());
        InstrumentDO receiverInstrumentDO = instrumentController.getInstrumentByID(txnDO.getReceiverId(), txnDO.getCreditInstrumentId());

        if (senderInstrumentDO == null || receiverInstrumentDO == null) {
            throw new IllegalArgumentException("Invalid instrument IDs");
        }

        boolean processed = processor.processPayment(senderInstrumentDO, receiverInstrumentDO);

        Transaction txn = new Transaction();
        txn.setAmount(txnDO.getAmount());
        txn.setTxnID(new Random().nextInt(90) + 10); // random 10-99
        txn.setSenderId(txnDO.getSenderId());
        txn.setReceiverId(txnDO.getReceiverId());
        txn.setDebitInstrumentId(txnDO.getDebitInstrumentId());
        txn.setCreditInstrumentId(txnDO.getCreditInstrumentId());
        txn.setStatus(processed ? TransactionStatus.SUCCESS : TransactionStatus.FAILED);

        // Add transaction to sender
        userVsTransactionsList.computeIfAbsent(txn.getSenderId(), k -> new ArrayList<>()).add(txn);

        // Add transaction to receiver
        userVsTransactionsList.computeIfAbsent(txn.getReceiverId(), k -> new ArrayList<>()).add(txn);

        txnDO.setTxnID(txn.getTxnID());
        txnDO.setStatus(txn.getStatus());

        return txnDO;
    }
}
