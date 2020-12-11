package dev.dietermai.sailautil.dispatch;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

public class CooldownJob<T> {
	private final Duration cooldown;
	private final JobExecutor dispatcher;
	private final AbstractJob<T> payload;
	
	private JobAccess<T> jobAccess;
	
	public CooldownJob(JobExecutor dispatcher, AbstractJob<T> payload, Duration cooldown) {
		Objects.requireNonNull(dispatcher);
		Objects.requireNonNull(payload);
		Objects.requireNonNull(cooldown);
		
		this.dispatcher = dispatcher;
		this.payload = payload;
		this.cooldown = cooldown;
	}
	
	public JobAccess<T> trigger(){
		if(jobAccess != null ) {
			return jobAccess = dispatcher.addJob(payload);
		}else if(!jobAccess.getFuture().isDone()){
			return jobAccess;
		}else {
			LocalTime lastStart = jobAccess.getInfo().getStart();
			Duration duration = Duration.between(lastStart, LocalTime.now());
			if(duration.minus(cooldown).isNegative()) {
				return jobAccess = dispatcher.addJob(payload);
			}
			return jobAccess;
		}
	}
}
