package com.ais.design.behavioral;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*;

/*
 * Let more than one object handle a request without their knowing each other. 
 * Pass the request to chained objects until it has been handled.
 */
public class ChainOfResponsabilityPattrnTest {

	@Test
	public void test() {
		Manager manager = new Manager();
        Director director = new Director();
        VicePresident vp = new VicePresident();
        President president = new President();
        manager.setSuccessor(director);
        director.setSuccessor(vp);
        vp.setSuccessor(president);
        
        double amount = 7900;

        manager.processRequest(new PurchaseRequest(0, amount, "General"));

	}

}

abstract class PurchasePower {

    protected final double base = 500;
    protected PurchasePower successor;

    public void setSuccessor(PurchasePower successor){
        this.successor = successor;
    }

    abstract public void processRequest(PurchaseRequest request);
}

class Manager extends PurchasePower {
    private final double ALLOWABLE = 10 * base;

    public void processRequest(PurchaseRequest request ) {
        if( request.getAmount() < ALLOWABLE )
            System.out.println("Manager will approve $"+ request.getAmount());
        else
           if( successor != null)
               successor.processRequest(request);
  }
}

class Director extends PurchasePower {
    private final double ALLOWABLE = 20 * base;

    public void processRequest(PurchaseRequest request ) {
        if( request.getAmount() < ALLOWABLE )
            System.out.println("Director will approve $"+ request.getAmount());
        else
           if( successor != null)
               successor.processRequest(request);
  }
}

class VicePresident extends PurchasePower {
    private final double ALLOWABLE = 40 * base;

    public void processRequest(PurchaseRequest request) {
        if( request.getAmount() < ALLOWABLE )
            System.out.println("Vice President will approve $" + request.getAmount());
        else
        if( successor != null )
            successor.processRequest(request);
  }
}

class President extends PurchasePower {
    private final double ALLOWABLE = 60 * base;
   
    public void processRequest(PurchaseRequest request){
        if( request.getAmount() < ALLOWABLE )
            System.out.println("President will approve $" + request.getAmount());
        else
            System.out.println( "Your request for $" + request.getAmount() + " needs a board meeting!");
    }
}

class PurchaseRequest {
  
    private int number;
    private double amount;
    private String purpose;

    public PurchaseRequest(int number, double amount, String purpose){
        this.number = number;
        this.amount = amount;
        this.purpose = purpose;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amt){
        amount = amt;
    }
    
    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String reason) {
        purpose = reason;
    }

    public int getNumber(){
        return number;
    }
    public void setNumber(int num) {
        number = num;
     }   
}