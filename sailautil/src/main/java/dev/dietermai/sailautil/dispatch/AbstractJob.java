package dev.dietermai.sailautil.dispatch;

import java.util.concurrent.Callable;

public abstract class AbstractJob<T> implements Callable<T>{
	
	public String getName() {
		return this.getClass().getSimpleName();
	}

	public JobResult getJobResult() {
		return null;
	}
}
