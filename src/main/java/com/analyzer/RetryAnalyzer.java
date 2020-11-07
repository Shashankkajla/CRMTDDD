package com.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int count =0; // start from 0
	int retryLimit =3; // till 3 times failure will be executed
	
	
	
	@Override
	public boolean retry(ITestResult result) { // retry method which overrides from IretryAnalyzer

		if(count< retryLimit){
			count++;
			return true;
		}
		
		return false;
	}

}
