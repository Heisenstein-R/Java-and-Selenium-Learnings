package com.retrylogic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryLogic {
	
	
	@Test(retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void test1() {
		Assert.assertEquals(true, false);
	}
	

	@Test(retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void test2() {
		Assert.assertEquals(true, false);
	}
	
	@Test(retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void test3() {
		Assert.assertEquals(true, true);
	}
}
