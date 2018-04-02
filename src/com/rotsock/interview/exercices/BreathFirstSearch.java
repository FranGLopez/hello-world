package com.rotsock.interview.exercices;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.rotsock.datatypes.RotNodeDirectedGraph;
import com.rotsock.datatypes.RotNodeTree;
/**
 * 
 * This class is my personal implementation of BFS for tree and graph (Búsqueda en anchura)
 * 
 * Unlike trees, Graphs may contain cycles.  
 * 
 * @author czx0274
 *
 */
public class BreathFirstSearch {
	
	
	public static <T> RotNodeTree<T> searchBFS (RotNodeTree<T> Tree, T value){
		LinkedList<RotNodeTree<T>> nodesToIterate;
		RotNodeTree<T> nodeT1;
		nodesToIterate = new LinkedList<RotNodeTree<T>>();
		nodesToIterate.add(Tree);
		while (!(nodesToIterate.isEmpty()) ){
			//Step 1 get first value of de list
			nodeT1 = nodesToIterate.removeFirst();
			//Step 2 check if the node is the value looked.
			if (value.equals(nodeT1.getValue())){
				//if found return the node.
				return nodeT1;
			}
			//Step 3 Add all the children to the list.
			nodesToIterate.addAll(nodeT1.getChildren());
		}
		return null;
	}
	
	/**
	 * Same search as searchBFS but checking that a node can't be iterate twice
	 * @param Tree
	 * @param value
	 * @return
	 */
	public static <T> RotNodeDirectedGraph<T> searchGraphBFS (RotNodeDirectedGraph<T> Tree, T value){
		LinkedList<RotNodeDirectedGraph<T>> nodesToIterate;
		RotNodeDirectedGraph<T> nodeT1;
		Set<RotNodeDirectedGraph<T>> IteratedNodes;
		nodesToIterate = new LinkedList<RotNodeDirectedGraph<T>>();
		IteratedNodes = new HashSet<RotNodeDirectedGraph<T>>();
		nodesToIterate.add(Tree);
		while (!(nodesToIterate.isEmpty()) ){
			//Step 1 get first value of de list
			nodeT1 = nodesToIterate.removeFirst();
			//Step 2 check if the node is the value looked.
			if (value.equals(nodeT1.getValue())){
				//if found return the node.
				return nodeT1;
			}
			//Step 3 Add all the adjacent vertex without repeticions
			for (RotNodeDirectedGraph<T> nodeToCheck : nodeT1.getAdjacentNodes()){
				//Step 3.1 Check if the node is already added.
				if (!IteratedNodes.contains(nodeToCheck)){
					//Step 3.2 if the node is not added, we added to the nodes to iterate.
					nodesToIterate.add(nodeToCheck);	
					IteratedNodes.add(nodeToCheck);
				}
			}
		}
		return null;
	}
	
	
	
}
