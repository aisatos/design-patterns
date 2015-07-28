package com.ais.design.creational;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Provides one level of interface higher than the factory pattern. It is used to return one of several factories.
 * the factories extend the abstract factory.
 */
public class AbstractFactoryPatternTest {

	@Test
	public void test() {
		
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		Shape shape = shapeFactory.getShape("CIRCLE");

		assertNotNull(shape);
		assertTrue("Rectangle should be of class Rectangle", shape.getClass().equals(Rectangle.class));
	}

}

class FactoryProducer {
	   public static AbstractFactory getFactory(String choice){
	   
	      if("SHAPE".equalsIgnoreCase(choice)){
	         return new ShapeFactory();
	         
	      }else if("COLOR".equalsIgnoreCase(choice)){
	         return new ColorFactory();
	      }
	      
	      return null;
	   }
	}

abstract class AbstractFactory {
	   abstract Color getColor(String color);
	   abstract Shape getShape(String shape) ;
}

class ShapeFactory extends AbstractFactory{
	public Shape getShape(String type){
		if (type == null)
			return null;
		else if ("RECTANGLE".equals(type))
			return new Rectangle();
		else if ("CIRCLE".equals(type))
			return new Circle();
		else if ("TRIANGLE".equals(type))
			return new Triangle();	
		return null;
	}
	
	@Override
	Color getColor(String color) {
	    return null;
	}
}


interface Shape {
	public void draw();
}

class Rectangle implements Shape{
	public void draw() {
		System.out.println("Rectangle");
	}
}

class Circle implements Shape{
	public void draw() {
		System.out.println("Circle");
	}
}
class Triangle implements Shape{
	public void draw() {
		System.out.println("Triangle");
	}
}

interface Color {
   void fill();
}

class Red implements Color {
	   public void fill() {
	      System.out.println("Inside Red::fill() method.");
	   }
}

class Green implements Color {
	   public void fill() {
	      System.out.println("Inside Green::fill() method.");
	   }
}

class ColorFactory extends AbstractFactory {
	
	   @Override
	   public Shape getShape(String shapeType){
	      return null;
	   }
	   
	   @Override
	   Color getColor(String color) {
	   
	      if(color == null)
	         return null;

	      if("RED".equalsIgnoreCase(color))
	         return new Red();
	      else if("GREEN".equalsIgnoreCase(color))
	         return new Green();
	      
	      return null;
	   }
	}
