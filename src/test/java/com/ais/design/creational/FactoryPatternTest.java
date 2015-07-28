package com.ais.design.creational;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/*
 * Provides an abstraction or an interface and lets subclass or implementing classes decide which class 
 * 	or method should be instantiated or called, based on the conditions or parameters given.
 */
public class FactoryPatternTest {
	
	private ShapeFactory shapeFactory;
	
	@Before
	public void Before(){
		shapeFactory = new ShapeFactory();
	}

	@Test
	public void TestRectangle (){
		Shape shape = shapeFactory.getShape("RECTANGLE");
		
		assertNotNull(shape);
		assertTrue("Rectangle should be of class Rectangle", shape.getClass().equals(Rectangle.class));
	}
}
//
//class ShapeFactory{
//	public Shape getShape(String type){
//		if (type == null)
//			return null;
//		else if ("RECTANGLE".equals(type))
//			return new Rectangle();
//		else if ("CIRCLE".equals(type))
//			return new Circle();
//		else if ("TRIANGLE".equals(type))
//			return new Triangle();	
//		return null;
//	}
//}
//
//
//interface Shape {
//	public void draw();
//}
//
//class Rectangle implements Shape{
//	public void draw() {
//		System.out.println("Rectangle");
//	}
//}
//
//class Circle implements Shape{
//	public void draw() {
//		System.out.println("Circle");
//	}
//}
//class Triangle implements Shape{
//	public void draw() {
//		System.out.println("Triangle");
//	}
//}