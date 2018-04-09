package com.rotsock.JavaTeory.designpatterns.factory;
/**
 * Factory Method
 * 
 * Se define un proceso y se permite a las clases que extiendan al proceso definir parte de la funcionalidad.
 * Por ejemplo, en este caso pickFruit realiza tareas con la fruta que cada clase elija.
 * @author czx0274
 *
 */
abstract class FruitPicker {

	protected abstract Fruit makeFruit();
	
	public void pickFruit() {
	    final Fruit f = makeFruit();
	    /**
	     * Execute a process with the fruit that is choosen.
	     */
	}
	
}
