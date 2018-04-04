package com.rotsock.interview.exercices;
/**
 * La búsqueda binaria funciona para arrays de objetos ordenados.
 * Hay una variante  SearchSortedRotated que busca en arrays ordenados pero que presentan una rotación. Ejemplo: {5, 6, 7, 8, 9, 10, 1, 2, 3}
 * @author czx0274
 *
 * @param <T>
 */
public class BinaySearch<T  extends Comparable<T>> {
	
	
/**
 * An element in a sorted array can be found in O(log n) time via binary search.
 *  But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. 
 *  So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the 
 *  rotated array in O(log n) time.
 * 
 */
	
	/**
	 * Examples:
	 * arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
	 * key = 3
	 * return Found at index 8
	 * 
	 * arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
     * key = 30
	 *  return not found;
	 */
	public int SearchSortedRotated (T[] A, T value){
		//Está ordenado pero está desplazado
		int itPivot,itFrom,itTo;
		T valuePivot,valueFrom,valueTo;
		itFrom = 0;
		itTo = A.length-1;
		itPivot= ShiftPivot (0, A.length-1);
		valuePivot = A[itPivot];
		valueFrom = A[itFrom];
		valueTo = A[itTo];
		while (!valuePivot.equals(value)){
			//Se llegó al final y no se encontró nada
			if (itPivot ==itFrom || itPivot == itTo){
				return -1;
			}
			//Está en orden el subconjunto de la izquierda y key está a la izquierda
			else if (origIsLessThanThat(valueFrom,valuePivot)){
				if (origIsLessThanThat(value,valuePivot) && (origIsGreaterThanThat(value,valueFrom)|| equals(value,valueFrom)) ){
					//moverse a la izquierda
					itTo = itPivot;
					itPivot = itPivot- ShiftPivot(itFrom,itPivot);
				}
				else{
					//moverse a la derecha
					itFrom = itPivot;
					itPivot = itPivot+ ShiftPivot(itPivot,itTo);
				}
			}
			//Está en orden el subconjunto de la derecha y key está a la derecha
			else if (origIsGreaterThanThat(valueTo,valuePivot)){
				if (origIsGreaterThanThat(value,valuePivot)&& (origIsLessThanThat(value,valueTo)||equals(value,valueFrom))){
					//moverse a la derecha
					itFrom = itPivot;
					itPivot = itPivot+ ShiftPivot(itPivot,itTo);
				}
				else{
					//moverde a la izquierda
					itTo = itPivot;
					itPivot = itPivot- ShiftPivot(itFrom,itPivot);
				}
			}
			valuePivot = A[itPivot];
			valueFrom = A[itFrom];
			valueTo = A[itTo];
		}
		return itPivot;
	}
	
	private boolean origIsGreaterThanThat(T orig, T that) {
	    return orig.compareTo(that) > 0;
	}
	private  boolean origIsLessThanThat(T orig, T that) {
	    return orig.compareTo(that) < 0;
	}
	private boolean equals(T orig, T that){
		return orig.compareTo(that)==0;
	}
	
	
	
	
	/**
	 * @pre: A tiene que estar ordenado, si no, la búsqueda binaria no funciona
	 * @param key
	 * @return
	 */
	public int BinarySearch (T[] A, T value){
		//busqueda binaria
		int itPivot,itFrom,itTo;
		T valueCandidate;
		itFrom = 0;
		itTo = A.length-1;
		itPivot= ShiftPivot (0, A.length-1);
		valueCandidate = A[itPivot];
		while (!valueCandidate.equals(value)){
			if (itPivot ==itFrom || itPivot == itTo){
				//Se llegó al final y no se encontró nada
				return -1;
			}
			else if (origIsGreaterThanThat(valueCandidate,value)){
				//moverse a la izquierda
				itTo = itPivot;
				itPivot = itPivot- ShiftPivot(itFrom,itPivot);
			}
			else if (origIsLessThanThat(valueCandidate,value)){
				//moverse a la derecha
				itFrom = itPivot;
				itPivot = itPivot+ ShiftPivot(itPivot,itTo);
			}
			valueCandidate = A[itPivot];
		}
		return itPivot;
	}
	
	
	private int ShiftPivot (int from, int to){
		return (int)java.lang.Math.ceil((to-from)/2.0f);
	}
	
	
	

}
