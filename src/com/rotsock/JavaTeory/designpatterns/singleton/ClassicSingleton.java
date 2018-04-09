package com.rotsock.JavaTeory.designpatterns.singleton;

//TODO: Continuar aumentando los ejemplos de distinso singleton.
/**
 * https://www.javaworld.com/article/2073352/core-java/simply-singleton.html?page=3
 * @author czx0274
 *
 */
public class ClassicSingleton {
	   private static ClassicSingleton instance = null;
	  
	   protected ClassicSingleton() {
	      //De esta forma no se puede llamar al constructor.
	   }
	   public static ClassicSingleton getInstance() {
		   //lazy instance.
	      if(instance == null) {
	         instance = new ClassicSingleton();
	      }
	      return instance;
	   }
	   
	   public static void Example(){
		   /**
		    * Así se instancia el singleton
		    */
		   ClassicSingleton singleton = ClassicSingleton.getInstance();
		   /**
		    * singleton es la misma instancia en todos los lugares donde se instancie.
		    */
	   }
	}
