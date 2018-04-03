package com.rotsock.interview.exercices.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.rotsock.interview.exercices.BillingPhone;

public class BillingPhoneTest {

	@Test
	public void test() {
		String test = "00:01:07,400-234-090\r\n" + 
				"00:05:01,701-080-080\r\n" + 
				"00:05:00,400-234-090";
		BillingPhone s = new BillingPhone();
		System.out.println(s.solution(test));
		assertEquals(900, s.solution(test));
	}

}
