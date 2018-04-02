package com.rotsock.datatypes.interfaces;

import java.util.List;

/*
 * T1 Type of the vertex
 * T2 Type of the edge 
 */
interface Graph<T1,V> {
	
	public boolean adjacent(T1 vertex1, T1 vertex2);
	public List<T1> neighbors(T1 vertex1);
	
	public void addVertex(T1 vertex1);
	public void removeVertex(T1 vertex1);
	public V getVertexValue (T1 vertex1);
	public void setVertexValue (T1 vertex1, V value);
	
	public void addEdge(T1 vertex1,T1 vertex2);
	public void removeEdge(T1 vertex1,T1 vertex2);
	public V getEdgeValue (T1 vertex1,T1 vertex2);
	public void setEdgeValue (T1 vertex1,T1 vertex2, V value);
}
