package com.rotsock.JavaTeory.designpatterns.factory;

/**
 * Factory Method
 * Esta clase selecciona una naranja, es decir, el procedimiento pickFruit de FruitPicker utilizará una naranja en su proceso.
 * @author czx0274
 *
 */
public class OrangePicker extends FruitPicker {

	@Override
	protected Fruit makeFruit() {
		// TODO Auto-generated method stub
		return new Orange();
	}
	
	public class Orange implements Fruit{
		  
	  }

}
