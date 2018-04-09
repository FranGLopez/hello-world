package com.rotsock.JavaTeory.DependencyInjection.noFramework;

public class SpringController {
	
	public static void main (String[] args){
		ApplicationContext cts = new  AnnotationConfigApplicationContext ("di.spring");
		View v = cts.getBean("myView",View.class);
		v.displayMessage();
	}
	
	//tasks to do
	/**
	 * 1º Cargar el context de Spring que da inyeccion de dependencia
	 * 2º Obtener una View del context.
	 * 3º Ask the view to display some data.
	 */

}
