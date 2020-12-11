package dev.dietermai.sailautil.dispatch;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class JobExecutor {
	
	private final ScheduledExecutorService jobExecutor;
	private final JobLogger logger = new JobLogger();
	
	
	public static JobExecutor createDefault(){
		final var executor = Executors.newSingleThreadScheduledExecutor();
		return new JobExecutor(executor);
	}
	
	public JobExecutor(final ScheduledExecutorService executor) {
		Objects.requireNonNull(executor);
		
		this.jobExecutor = executor;
	}
	
	public <T> JobAccess<T> addJob(AbstractJob<T> job) {
		if(job == null) {
			return null;
		}
		
		LoggingJobWrapper<T> logJob = new LoggingJobWrapper<>(job, logger);
		var future = jobExecutor.schedule(logJob, 0, TimeUnit.NANOSECONDS);
		var info = logJob.getJobInfo();
		JobAccess<T> jobAccess = new JobAccess<>(future, info);
		return jobAccess;
	}
	
	public <T> JobAccess<T> addJob(AbstractJob<T> job, Duration delay) {
		if(job == null) {
			return null;
		}
		
		LoggingJobWrapper<T> logJob = new LoggingJobWrapper<>(job, logger);
		var future = jobExecutor.schedule(logJob, delay.toNanos(), TimeUnit.NANOSECONDS);
		var info = logJob.getJobInfo();
		JobAccess<T> jobAccess = new JobAccess<>(future, info);
		
		return jobAccess;
	}

	public void dumpExecutedJobs() {
		logger.dump();
	}
}
