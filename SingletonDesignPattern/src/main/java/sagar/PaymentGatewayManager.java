package sagar;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PaymentGatewayManager {

    private PaymentGatewayManager(){
        System.out.println("Payment Gateway Manager intialized");
    }

    private static PaymentGatewayManager instance;

    private static Lock mtx=new ReentrantLock();


    public static PaymentGatewayManager getInstance(){
        if(instance==null)
        {
            mtx.lock();
            try{
                if(instance==null) instance=new PaymentGatewayManager();

            }
            finally {
                mtx.unlock();
            }
        }
        return instance;
    }

    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through the payment gateway.");
    }

}


