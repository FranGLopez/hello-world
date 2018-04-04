package com.rotsock.interview.exercices.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rotsock.interview.exercices.BinaySearch;

public class BinarySearchTest {
	
	BinaySearch<Integer> search = new BinaySearch<Integer>();

	@Test
	public void test() {
		Integer key,i;
		Integer []test1 = {1,2,3,4,5,6,7,8,9,10};
		Integer []test2 = {5,6,7,8,9,10,1,2,3};
		
		Integer [] values = {5,1,6,10,4,11,0};
		
		Integer [] keys_1 = {4,0,5,9,3,-1,-1};
		Integer [] keys_2 = {0,6,1,5,-1,-1,-1};
		
		i=0;
		for (int value : values){
			key = search.BinarySearch(test1, value);
			System.out.println("Found the value["+value+"] in the key " +key);
			assertEquals(key,keys_1[i]);
			i++;
		}
		
		i=0;
		for (int value : values){
			key = search.SearchSortedRotated(test2, value);
			System.out.println("Found the value["+value+"] in the key " +key);
			assertEquals(key,keys_2[i]);
			i++;
		}
	}

}
