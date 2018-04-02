package com.rotsock.interview.exercices.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rotsock.datatypes.RotNodeDirectedGraph;
import com.rotsock.datatypes.RotNodeTree;
import com.rotsock.interview.exercices.BreathFirstSearch;


public class BreathFirstSearchTest {
	@Test
	public void testBFSTree() throws Exception {
		//1 BUILD A TREE.
		RotNodeTree<Integer> tree,n4_1,n2_1,n5_1,n7_2,n4_2,n8_2,n9_2,n10_2,n4_3,result;
		tree = new RotNodeTree<Integer>(1);
		n2_1 = new RotNodeTree<Integer>(2);
		n4_1 = new RotNodeTree<Integer>(4);
		n5_1 = new RotNodeTree<Integer>(5);
		n7_2 = new RotNodeTree<Integer>(7);
		n4_2 = new RotNodeTree<Integer>(4);
		n8_2 = new RotNodeTree<Integer>(8);
		n9_2 = new RotNodeTree<Integer>(9);
		n10_2 = new RotNodeTree<Integer>(10);
		n4_3 = new RotNodeTree<Integer>(4);
		
		tree.addChildren(n2_1);
		tree.addChildren(n4_1);
		tree.addChildren(n5_1);
		n2_1.addChildren(n7_2);
		n2_1.addChildren(n4_2);
		n4_1.addChildren(n8_2);
		n4_1.addChildren(n9_2);
		n5_1.addChildren(n10_2);
		n10_2.addChildren(n4_3);
		
		/**  
		 *       7
		 *    2
		 *       4
		 *       
		 *       
		 *       8
		 * 1  4
		 *       9
		 *       
		 *       
		 *    5  10   4
		 */
		 result = BreathFirstSearch.searchBFS(tree,4);
		 //Same node
		 assertEquals(n4_1,result);
		 //same value
		 assertEquals(n4_1.getValue(),result.getValue());
		 //it's not a leaf
		 assertFalse(result.isLeaf());
		 //it's the root
		 assertEquals(BreathFirstSearch.searchBFS(tree,1),tree);
		 //doesn't exist
		 assertEquals(BreathFirstSearch.searchBFS(tree,11),null);
	}
	
	
	@Test
	public void testBFSGraph() throws Exception {
		//1 BUILD A Graph.
		RotNodeDirectedGraph<Integer> start,n0,n1,n3,result;
		start = new RotNodeDirectedGraph<Integer>(2);
		n0 = new RotNodeDirectedGraph<Integer>(0);
		n1 = new RotNodeDirectedGraph<Integer>(1);
		n3 = new RotNodeDirectedGraph<Integer>(3);
		start.addAdjacentNodes(n0);
		start.addAdjacentNodes(n3);
		n0.addAdjacentNodes(n1);
		n0.addAdjacentNodes(start);
		n1.addAdjacentNodes(start);
		n3.addAdjacentNodes(n3);
		
		/**  
		 * Graph
		 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
		 */
		 result = BreathFirstSearch.searchGraphBFS(start, 3);
		 //Same node
		 assertEquals(n3,result);
		 //same value
		 assertEquals(n3.getValue(),result.getValue());
		 //it's the root
		 assertEquals(BreathFirstSearch.searchGraphBFS(start,2),start);
		 //doesn't exist
		 assertEquals(BreathFirstSearch.searchGraphBFS(start,11),null);
	}
	

}
