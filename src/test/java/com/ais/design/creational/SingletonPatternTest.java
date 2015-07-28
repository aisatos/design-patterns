package com.ais.design.creational;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * One instance of a class or one value accessible globally in an application.
 * Make the constructor private and the instance of the class a Local static(class) variable.
 */
public class SingletonPatternTest {

	@Test
	public void test() {
		SingleObject singleObject = SingleObject.getInstance();
		
		assertNotNull("Single object shouldn't be null", singleObject);
	}

}
class SingleObject {

	   private static SingleObject instance = new SingleObject();

	   //make the constructor private so that this class cannot be instantiated
	   private SingleObject(){}

	   public static SingleObject getInstance(){
	      return instance;
	   }

	   public void showMessage(){
	      System.out.println("Hello World!");
	   }
	}