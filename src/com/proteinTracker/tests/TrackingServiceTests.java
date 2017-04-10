package com.proteinTracker.tests;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import com.protein.InvalidGoalException;
import com.protein.TrackingService;

public class TrackingServiceTests {

	private TrackingService service;
	
	@BeforeClass
	public static void before(){
		System.out.println("Before class");
	}
	
	@AfterClass
	public static void after(){
		System.out.println("After Class");
	}
	
	@Before
	public void setUp(){
		System.out.println("Before");
		service = new TrackingService();
	}

	@After
	public void tearDown(){
		System.out.println("After");
	}
	
	@Test
	@Category(GoodTestsCategory.class)
	public void newTrackignServiceTotalSizeIsZero() {
		assertEquals("Total was not equal to zero", 0, service.getTotal());

	}

	@Test
	@Category({GoodTestsCategory.class, BadTestsCategory.class})
	public void whenAddingProteinTotalIncreasesByThatAmount() {

		service.addProtein(10);
		assertEquals(10, service.getTotal());
		assertThat(service.getTotal(), is(10));
		
		assertThat(service.getTotal(), allOf(is(10), instanceOf(Integer.class)));

	}

	@Test
	@Category(GoodTestsCategory.class)
	public void whenRemovingProteinTotalRemainsZero() {
		for(int i=0; i< 10000000; i++)
			service.addProtein(1);
		service.removeProtein(15);
		assertEquals("Protein removed was not correct", 0, service.getTotal());
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	//@Test( expected = InvalidGoalException.class)
	@Test
	public void whenGoalIsSetToLessThanZeroExceptionisThrown() throws InvalidGoalException{
		thrown.expect(InvalidGoalException.class);
		//thrown.expectMessage("Goal was less than zero!");
		thrown.expectMessage(containsString("Goal"));
		service.setGoal(-5);
	}
	
	@Rule
	public Timeout timeout = new Timeout(20);
	
	//@Test(timeout = 200)
	@Test
	public void badTest(){
		for(int i=0; i< 10000000; i++)
			service.addProtein(1);
	}

}
