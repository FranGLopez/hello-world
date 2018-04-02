package com.rotsock.datatypes;

import java.util.ArrayList;
import java.util.List;

public class RotNodeTree<T> {
	
	private T value;
	
	//get the same rule as a  Double linked list but in one direction can be multiple objects.
	private  RotNodeTree<T> parent;
	private List<RotNodeTree<T>> children;
	
	public RotNodeTree(T value ){
		this();
		this.value = value;
	}
	
	public RotNodeTree(){
		children = new ArrayList<RotNodeTree<T>>();
		parent= null;
	}
	

	
	public void addChildren(RotNodeTree<T> node) throws Exception{
		//Cycles can't be created .
		if(node.parent ==null){
			node.parent= this;
			children.add(node);
		}
		else{
			throw new Exception("When adding a children. A tree can't have cycles or more than a parent.");
		}
	}
	
	
	public List<RotNodeTree<T>> getChildren(){
		return children;
		
	}
	
	public RotNodeTree<T> getParent(){
		return parent;
		
	}

	
	public boolean isLeaf(){
		return children.isEmpty();
		
	}
	
	public boolean isRoot(){
		return parent==null;
	}
	
	
	public T getValue(){
		return value;
	}
	
	
	public void setValue(T value){
		this.value = value;
		
	}
	
	
	
	

}
