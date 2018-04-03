package com.rotsock.interview.exercices.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.rotsock.interview.exercices.ExtractNumbers;

public class ExtractNumbersTest {

	@Test
	public void test() {
		List<Integer> output = ExtractNumbers.getNumbers("A56B455VB23GTY23J");
		
		for (int out : output) {
			System.out.println(out);
		}
	}

}
