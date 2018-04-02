package com.rotsock.datatypes;
/**
 * https://en.wikipedia.org/wiki/Directed_graph
 */
import java.util.ArrayList;
import java.util.List;

public class RotNodeDirectedGraph<T> {
	
	private T value;
	
	//get the same rule as a  Double linked list but in one direction can be multiple objects.
	private List<RotNodeDirectedGraph<T>> adjacentVertex;
	
	public RotNodeDirectedGraph(T value ){
		this();
		this.value = value;
	}
	
	public RotNodeDirectedGraph(){
		adjacentVertex = new ArrayList<RotNodeDirectedGraph<T>>();
	}
	
	public void addAdjacentNodes(RotNodeDirectedGraph<T> node) throws Exception{
		//Cycles can't be created.
		adjacentVertex.add(node);
	}
	
	
	public List<RotNodeDirectedGraph<T>> getAdjacentNodes(){
		return adjacentVertex;
		
	}
	
	public T getValue(){
		return value;
	}
	
	
	public void setValue(T value){
		this.value = value;
		
	}

}
