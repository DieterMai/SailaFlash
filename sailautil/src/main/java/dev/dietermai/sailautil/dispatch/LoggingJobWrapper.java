package dev.dietermai.sailautil.dispatch;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.Callable;

public class LoggingJobWrapper<T> implements Callable<T> {
	
	private final AbstractJob<T> payload;
	private final JobLogger logger;
	private final LocalTime queueTime;
	private JobInfo jobInfo;
	
	public LoggingJobWrapper(AbstractJob<T> payload, JobLogger logger) {
		this.payload = payload;
		this.logger = logger;
		this.queueTime = LocalTime.now(); // TODO put this into jobInfo
	}
	
	public Duration getExecutionDelay() {
		return Duration.between(queueTime, LocalTime.now());
	}
	
	public JobInfo getJobInfo() {
		return jobInfo;
	}
	
	public T call() {
		T t = null;
		jobInfo = new JobInfo();
		logger.add(jobInfo);
		try {
			jobInfo.setName(payload.getName());
			jobInfo.start();
			logger.logStart(jobInfo);
			t = payload.call();
			jobInfo.finish(payload.getJobResult());
		}catch(Exception e){
			jobInfo.finish(e);
		}
		logger.logEnd(jobInfo);
		
		return t;
	}
	
}
