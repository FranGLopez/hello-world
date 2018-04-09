package com.rotsock.JavaTeory.DependencyInjection.noFramework;

public class SpringController {
	
	public static void main (String[] args){
		ApplicationContext cts = new  AnnotationConfigApplicationContext ("di.spring");
		View v = cts.getBean("myView",View.class);
		v.displayMessage();
	}
	
	//tasks to do
	/**
	 * 1� Cargar el context de Spring que da inyeccion de dependencia
	 * 2� Obtener una View del context.
	 * 3� Ask the view to display some data.
	 */

}
