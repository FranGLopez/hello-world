package com.rotsock.JavaTeory.DependencyInjection.noFramework;

public class ControllerTghlyCoupled {
	
	public static void main (String[] args ){
		Model m = new SimpleModel();
		View v = new ConsoleViewer();
		((ConsoleViewer)v).setModel(m);
		v.displayMessage();
		
		//tasks to do
		/**
		 * 1� Create the model
		 * 2� Create the view
		 * 3� Tie the model into  the View
		 * 4� Ask the view to display some data.
		 */
	}

}
