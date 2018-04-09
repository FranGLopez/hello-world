package com.rotsock.JavaTeory.designpatterns.factory;

/**
 * Factory is "fixed", in that you have just one implementation with no subclassing.
 * @author czx0274
 *
 */
public class FruitFactory {

	  public Apple makeApple() {
	    // Code for creating an Apple here.
		  return new Apple();
	  }

	  public Orange makeOrange() {
	    // Code for creating an orange here.
		  return new Orange();
	  }

	  
	  
	  /**
	   * Para resumir la factoría. creo las clases dentro de FruitFactory
	   * @author czx0274
	   *
	   */
	  public class Apple implements Fruit{
		  
	  }
	  
	  public class Orange implements Fruit{
		  
	  }
	  
	}