package com.sagar;

import com.sagar.user.UserController;
import com.sagar.user.UserDO;

import java.util.List;

public class PaymentGateway {
    public static void main(String[] args) {
        InstrumentController instrumentController = new InstrumentController();
        UserController userController = new UserController();
        TransactionController transactionController = new TransactionController();

        // 1. add USER1
        UserDO user1 = new UserDO();
        user1.setName("Sj");
        user1.setMail("sj@conceptandcoding.com");
        UserDO user1Details = userController.addUser(user1);

        // 2. add USER2
        UserDO user2 = new UserDO();
        user2.setName("Pj");
        user2.setMail("pj@conceptandcoding.com");
        UserDO user2Details = userController.addUser(user2);

        // add bank instrument to User1
        InstrumentDO bankInstrumentDO = new InstrumentDO();
        bankInstrumentDO.setBankAccountNumber("234324234324324");
        bankInstrumentDO.setInstrumentType(InstrumentType.BANK);
        bankInstrumentDO.setUserID(user1Details.getUserID());
        bankInstrumentDO.setIfsc("ER3223E");
        InstrumentDO user1BankInstrument = instrumentController.addInstrument(bankInstrumentDO);
        System.out.println("Bank Instrument created for User1: " + user1BankInstrument.getInstrumentID());

        // add card instrument to User2
        InstrumentDO cardInstrumentDO = new InstrumentDO();
        cardInstrumentDO.setCardNumber("1230099");
        cardInstrumentDO.setInstrumentType(InstrumentType.CARD);
        cardInstrumentDO.setCvv("0000");
        cardInstrumentDO.setUserID(user2Details.getUserID());
        InstrumentDO user2CardInstrument = instrumentController.addInstrument(cardInstrumentDO);
        System.out.println("Card Instrument created for User2: " + user2CardInstrument.getInstrumentID());

        // make payment
        TransactionDO transactionDO = new TransactionDO();
        transactionDO.setAmount(10);
        transactionDO.setSenderId(user1Details.getUserID());
        transactionDO.setReceiverId(user2Details.getUserID());
        transactionDO.setDebitInstrumentId(user1BankInstrument.getInstrumentID());
        transactionDO.setCreditInstrumentId(user2CardInstrument.getInstrumentID());

        TransactionDO paymentResult = transactionController.makePayment(transactionDO);
        System.out.println("Transaction " + paymentResult.getTxnID() + " Status: " + paymentResult.getStatus());

        // get All instruments of USER1
        List<InstrumentDO> user1Instruments = instrumentController.getAllInstruments(user1Details.getUserID());
        for (InstrumentDO instrumentDO : user1Instruments) {
            System.out.println("User1 InstID: " + instrumentDO.getInstrumentID() +
                    ": UserID: " + instrumentDO.getUserID() +
                    ": InstrumentType: " + instrumentDO.getInstrumentType().name());
        }

        // get All instruments of USER2
        List<InstrumentDO> user2Instruments = instrumentController.getAllInstruments(user2Details.getUserID());
        for (InstrumentDO instrumentDO : user2Instruments) {
            System.out.println("User2 InstID: " + instrumentDO.getInstrumentID() +
                    ": UserID: " + instrumentDO.getUserID() +
                    ": InstrumentType: " + instrumentDO.getInstrumentType().name());
        }

        // get All transaction history for user1
        List<Transaction> user1TransactionList = transactionController.getTransactionHistory(user1Details.getUserID());
        System.out.println("Transaction History for User1:");
        if (user1TransactionList != null) {
            for (Transaction txn : user1TransactionList) {
                System.out.println("TxnID: " + txn.getTxnID() + ", Amount: " + txn.getAmount() +
                        ", Sender: " + txn.getSenderId() + ", Receiver: " + txn.getReceiverId() +
                        ", Status: " + txn.getStatus());
            }
        } else {
            System.out.println("No transactions found.");
        }
    }
}
