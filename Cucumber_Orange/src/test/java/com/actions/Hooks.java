package com.actions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public void setUp() {
		// Driver created when openPage() is called in Background
	}
	
	@After
	public void tearDown() {
		HelperClass.quitDriver(); // Close after each scenario
	}
}
