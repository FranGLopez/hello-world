package com.rotsock.JavaTeory.designpatterns.factory;

public class AbstractFactory {
/**
 * Especifico como se crea una factoría abstracta.
 * 
 * Abstract factory is normally used for things like dependency injection/strategy,
 *  when you want to be able to create a whole family of objects that need to be of "the same kind", 
 *  and have some common base classes. Here's a vaguely fruit-related example. 
 *  The use case here is that we want to make sure that we don't accidentally use an OrangePicker on an Apple.
 *  As long at we get our Fruit and Picker from the same factory, they will match.
 * 
 */
}

/**
 * Aquí defines una interface de interfaces, cada función devolverá una función de cada tipo
 * @author czx0274
 *
 */
interface PlantFactory {

	  public Plant makePlant();

	  public Picker makePicker(); 

	}

/**
 * La factoría abstracta agrupa la familia de implementaciones de Apple con ApplePicker y Melon con MelonPicker
 * @author czx0274
 *
 */

interface Plant{
	
}

interface Picker{
	
}

class Apple implements Plant{
	
}
class ApplePicker implements Picker{
	
}

class Melon implements Plant{
	
}
class MelonPicker implements Picker{
	
}



class AppleFactory implements PlantFactory {
	  public Plant makePlant() {
	    return new Apple();
	  }

	  public Picker makePicker() {
	    return new ApplePicker();
	  }
	}

class MelonFactory implements PlantFactory {
	public Plant makePlant() {
	    return new Melon();
	  }

	public Picker makePicker() {
	    return new MelonPicker();
	  }
	}