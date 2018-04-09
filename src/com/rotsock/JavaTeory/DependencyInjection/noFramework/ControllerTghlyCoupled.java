package com.rotsock.JavaTeory.DependencyInjection.noFramework;

public class ControllerTghlyCoupled {
	
	public static void main (String[] args ){
		Model m = new SimpleModel();
		View v = new ConsoleViewer();
		((ConsoleViewer)v).setModel(m);
		v.displayMessage();
		
		//tasks to do
		/**
		 * 1º Create the model
		 * 2º Create the view
		 * 3º Tie the model into  the View
		 * 4º Ask the view to display some data.
		 */
	}

}
