package dev.dietermai.sailautil.dispatch;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

public class JobInfo {
	public enum LifeCycleState{
		initial, running, done;
	}
	
	public enum ResultState{
		none, success, failur, error;
	}
	
	private LifeCycleState lifeCycleState = LifeCycleState.initial;
	private ResultState resultState = ResultState.none;
	private LocalTime start;
	private LocalTime end;
	private Exception e;
	private JobResult result;
	private String name;
	
	
	public LifeCycleState getLifeCycleState() {
		return lifeCycleState;
	}
	
	public void start() {
		lifeCycleState = LifeCycleState.running;
		start = LocalTime.now();
	}
	
	public void finish(JobResult result) {
		lifeCycleState = LifeCycleState.done;
		resultState = ResultState.success;
		end = LocalTime.now();
		this.result = result;
	}
	
	public void finish(Exception e) {
		lifeCycleState = LifeCycleState.done;
		resultState = ResultState.error;
		end = LocalTime.now();
		this.e = e;
	}
	
	public ResultState getResultState() {
		return resultState;
	}
	
	public LocalTime getStart() {
		return start;
	}
	
	public LocalTime getEnd() {
		return end;
	}
	
	public Exception getE() {
		return e;
	}
	
	public JobResult getJobResult() {
		return result;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Duration getElapsed() {
		return switch(lifeCycleState) {
		case initial -> Duration.ZERO;
		case running -> timeDelta(start, LocalTime.now());
		case done -> timeDelta(start,end);
		};
	}
	
	private Duration timeDelta(LocalTime start, LocalTime end) {
			return Duration.between(start, end);
	}

	@Override
	public int hashCode() {
		return Objects.hash(end, lifeCycleState, resultState, start, result);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		JobInfo other = (JobInfo) obj;
		return end == other.end && lifeCycleState == other.lifeCycleState && resultState == other.resultState && start == other.start && result == other.result;
	}

	@Override
	public String toString() {
		return "JobInfo [start=" + start + ", end=" + end + ", lifeCycleState=" + lifeCycleState + ", resultState=" + resultState + ", e=" + e + ", name=" + name + ", result=" + result + "]";
	}
	
	
}
