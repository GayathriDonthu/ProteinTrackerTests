package com.proteinTracker.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.protein.InvalidGoalException;
import com.protein.SMSNotifier;
import com.protein.TrackingService;
import com.techventus.server.voice.Voice;
import com.techventus.server.voice.datatypes.records.SMSThread;

public class IntegrationTest {
	private Voice voice;
	
	@Before
	public void setUp() throws IOException{
		voice = new Voice("pluralsightdemo@gmail.com", "pluralsight123", "2083522168");
	}
	
	@Test
	public void goalMetShouldSendNotification() throws InvalidGoalException, IOException {
		
		TrackingService service = new TrackingService(new SMSNotifier("pluralsightdemo@gmail.com", "pluralsight123", "2083522168"));
		service.setGoal(50);
		service.addProtein(51);
		
		assertTrue(voice.getSMS().contains("goal met"));
	}
	
	@After
	public void tearDown() throws IOException {
		for(SMSThread thread : voice.getSMSThreads()){
			//	voice.deleteMessage(thread.getId());
		}
	}
	
}
