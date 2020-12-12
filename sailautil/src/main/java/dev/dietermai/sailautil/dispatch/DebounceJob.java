package dev.dietermai.sailautil.dispatch;

import java.time.Duration;
import java.util.Objects;

public class DebounceJob<T> {
	private final Duration silencePeriode;
	private final JobExecutor dispatcher;
	private final AbstractJob<T> payload;
	
	private JobAccess<T> jobAccess;
	
	public DebounceJob(JobExecutor dispatcher, AbstractJob<T> payload, Duration silencePeriode) {
		Objects.requireNonNull(dispatcher);
		Objects.requireNonNull(payload);
		Objects.requireNonNull(silencePeriode);
		
		this.dispatcher = dispatcher;
		this.payload = payload;
		this.silencePeriode = silencePeriode;
	}
	
	public JobAccess<T> trigger(){
		cancel();
		return jobAccess = dispatcher.addJob(payload, silencePeriode);
	}
	
	public void cancel() {
		if(jobAccess != null) {
			jobAccess.getFuture().cancel(false);
		}
	}
	
	public JobAccess<T> triggerNow() {
		cancel();
		return jobAccess = dispatcher.addJob(payload);
	}

	public void triggerNowIfPending() {
		if(isPending()) {
			triggerNow();
		}
	}
	
	public boolean isPending() {
		if(jobAccess != null && !jobAccess.getFuture().isDone()) {
			return true;
		}else {
			return false;
		}
	}
}
