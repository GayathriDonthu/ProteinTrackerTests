package com.proteinTracker.tests;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.protein.TrackingService;

@RunWith(Parameterized.class)
public class ParemterizedTests {
	
	
	private static TrackingService service = new TrackingService();
	private int input;
	private int expected;
	
	@Parameters
	public static List<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{5, 5},
			{5,10},
			{-12, 0},
			{50, 50},
			{1, 51}
		});
	}
	
	public ParemterizedTests(int input, int expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Test
	public void test(){
		if(input >= 0)
			service.addProtein(input);
		else
			service.removeProtein(-input);
		
		assertEquals(expected, service.getTotal());
	}
}
