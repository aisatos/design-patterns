package com.ais.design.behavioral;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * An object's behavior change is represented by its member classes, which share the same super class.
 */
public class StatePatternTest {
	String con = "management";
	Controller controller;
	
	@Test
	public void test() {
		controller = new Controller();
		con = "sales";
		// the following trigger should be made by the user
		if (con.equalsIgnoreCase("management"))
			controller.makeManagementConnection();
		if (con.equalsIgnoreCase("sales"))
			controller.makeSalesConnection();
		if (con.equalsIgnoreCase("accounting"))
			controller.makeAccountingConnection();
		controller.open();
		controller.log();
		controller.close();
	}

}
abstract class Connection {
	   public abstract void open();
	   public abstract void close();
	   public abstract void log();
	}
	class Accounting extends Connection {
	   public void open() {
	      System.out.println("open database for accounting");
	   }
	   public void close() {
	      System.out.println("close the database");
	   }
	   public void log() {
	      System.out.println("log activities");
	   }
	   //...
	}
	class Sales extends Connection {
	   public void open() {
	      System.out.println("open database for sales"); 
	   }
	   public void close() {
	      System.out.println("close the database");
	   }
	   public void log() {
	      System.out.println("log activities");
	   }
	   public void update() {
	      //
	   }
	}
	class Management extends Connection {
	   public void open() {
	      System.out.println("open database for management"); 
	   }
	   public void close() {
	      System.out.println("close the database");
	   }
	   public void log() {
	      System.out.println("log activities");
	   }
	   //...
	}
	class Controller {
	   public static Accounting acct;
	   public static Sales sales;
	   public static Management manage;
	   private static Connection current;
	   
	   Controller() {
	       acct = new Accounting();
	       sales = new Sales();
	       manage = new Management();
	   }
	   public void makeAccountingConnection() {
	       current = acct;
	   }
	   public void makeSalesConnection() {
	       current = sales;
	   }
	   public void makeManagementConnection() {
	       current = manage;
	   }
	   public void open() {
	       current.open();
	   }
	   public void close() {
	       current.close();
	   }
	   public void log() {
	       current.log();
	   }
	}