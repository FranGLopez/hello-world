package com.rotsock.JavaTeory.DependencyInjection.noFramework;

public class ConsoleViewer implements View {

	private Model model;
	@Override
	public void displayMessage() {
		System.out.println("ConsolerViewer:" + this.model.getMessage());
	}

	public void setModel(Model m) {
		this.model = m;
	}


}
