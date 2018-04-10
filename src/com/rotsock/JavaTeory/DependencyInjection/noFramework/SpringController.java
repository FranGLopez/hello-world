package com.rotsock.JavaTeory.DependencyInjection.noFramework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class SpringController {
	
	/**
	 * Defino un bean por vista, en cada uno defino una view distinta 
	 * SpringConsoleViewer o  SpringConsoleViewer2
	 * 
	 * En cada bean de la vista paso un modelo en concreto, lo que hago es:
	 * @Qualifier("springmodel1") Model springmodel1 para decir quiero como parametro de la vista el bean "springmodel1"
	 */
	
	
	@Bean(name = "viewModel")
	public View springview(@Qualifier("springmodel1") Model springmodel1){
		return new SpringConsoleViewer(springmodel1);
	}
	
	
	@Bean(name = "viewModel2")
	public View springview2(@Qualifier("springmodel2") Model springmodel2){
		return new SpringConsoleViewer2(springmodel2);
	}
	
	@Bean(name = "viewModel3")
	public View springview3(@Qualifier("springmodel2") Model springmodel2){
		return new SpringConsoleViewer(springmodel2);
	}
	
	
	
	
	@Bean
	public Model  springmodel1 (){
		return new Model(){
			@Override
			public String getMessage() {
				return "1 Bean Model:";
			}
			
		};
	}
	
	@Bean
	public Model  springmodel2 (){
		return new Model(){
			@Override
			public String getMessage() {
				return " 2 Bean Model:";
			}
			
		};
	}
	
	public static void main (String[] args){
		ApplicationContext cts = new  AnnotationConfigApplicationContext (SpringController.class);
		try{
			View v1_m1 = cts.getBean("viewModel",View.class);
			View v2_m2 = cts.getBean("viewModel2",View.class);
			View v1_m2 = cts.getBean("viewModel3",View.class);
			v1_m1.displayMessage();
			v2_m2.displayMessage();
			v1_m2.displayMessage();
		}
		finally{
			((AnnotationConfigApplicationContext) cts).close();
		}
	}
	
	//tasks to do
	/**
	 * 1º Cargar el context de Spring que da inyeccion de dependencia
	 * 2º Obtener una View del context.
	 * 3º Ask the view to display some data.
	 */

}
