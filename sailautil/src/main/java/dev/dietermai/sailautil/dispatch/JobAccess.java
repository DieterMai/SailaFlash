package dev.dietermai.sailautil.dispatch;

import java.util.concurrent.ScheduledFuture;

public class JobAccess<T> implements IJobAccess<T> {

	private ScheduledFuture<T> future;
	private JobInfo info;
	
	JobAccess(ScheduledFuture<T> future, JobInfo info){
		this.future = future;
		this.info = info;
	}
	
	@Override
	public ScheduledFuture<T> getFuture() {
		return future;
	}
	
	@Override
	public JobInfo getInfo() {
		return info;
	}
}
