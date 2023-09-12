package com.corporation.tax.myapp.utils;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;

public class MyAppSkipPolicy implements SkipPolicy {

	@Override
	public boolean shouldSkip(Throwable t, int skipCount) throws SkipLimitExceededException {
		// TODO Auto-generated method stub
		return true;
	}

}
